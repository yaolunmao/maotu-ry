<template>
    <div class="w-1/1">
        <el-button class="w-1/1" @click="onConfigClick">点击配置</el-button>
        <el-drawer v-model="dialogVisible" title="配置" direction="ltr">
            <el-form ref="ruleFormRef" :rules="rules" :model="bind_devices">
                <div v-for="(bind_device_item, index) in bind_devices" :key="index">
                    <div v-if="bind_device_item.bind_node_id == props.handItemInfo.id">
                        <el-form-item label="选择设备" size="small" :prop="`[${index}].device_id`" :rules="rules.device_id">
                            <el-select v-model="bind_device_item.device_id" placeholder="请选择设备" size="small"
                                @change="bind_device_item.device_prop = ''" :disabled="!bind_device_item.bind_btn_state">
                                <el-option v-for="device_item in device_list" :key="device_item.id"
                                    :label="device_item.name" :value="device_item.id"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="设备属性" size="small" :prop="`[${index}].device_prop`" :rules="rules.device_prop">
                            <el-select v-model="bind_device_item.device_prop" placeholder="请选择设备属性" size="small"
                                :disabled="!bind_device_item.bind_btn_state">
                                <el-option v-for="bind_prop_item in getBindDeviceProp(bind_device_item.device_id)"
                                    :key="bind_prop_item.value" :label="bind_prop_item.label"
                                    :value="bind_prop_item.value"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="图形属性" size="small" :prop="`[${index}].bind_node_prop`"
                            :rules="rules.bind_node_prop">
                            <el-select v-model="bind_device_item.bind_node_prop" placeholder="请选择图形属性" size="small"
                                :disabled="!bind_device_item.bind_btn_state">
                                <el-option v-for="handle_item_prop in getHandItemProp()" :key="handle_item_prop.label"
                                    :label="handle_item_prop.label" :value="handle_item_prop.value"></el-option>
                            </el-select>
                        </el-form-item>

                        <div>
                            <el-button v-if="bind_device_item.bind_btn_state" type="success" size="small" class="w-1/1"
                                @click="onDeviceBind(1, bind_device_item, index)">绑定</el-button>
                            <el-button v-else type="danger" size="small" class="w-1/1"
                                @click="onDeviceBind(2, bind_device_item, index)">解绑</el-button>
                        </div>
                        <el-divider></el-divider>
                    </div>
                </div>
            </el-form>
            <el-button type="primary" @click="onAddClick(bind_devices[bind_devices.length - 1]?.bind_btn_state ?? false)"
                class="w-1/1" size="small">新增</el-button>
        </el-drawer>
    </div>
</template>
<script setup lang="ts">
import {
    ElButton,
    ElDrawer,
    ElSelect,
    ElOption,
    ElFormItem,
    ElDivider,
    ElForm,
    ElMessage
} from "element-plus";
import { listSvgnode, unBindSvgnode, addSvgnode } from '@/api/webtopo/svgnode';
import { getProject, saveProject } from "@/api/webtopo/project";
import { reactive, ref } from "vue";
interface IBindDevice {
    bind_node_id: string;
    bind_node_prop: string;
    device_id: string;
    device_prop: string;
    bind_btn_state?: boolean;
}
interface IDeviceList {
    id: string;
    name: string;
    prop_list: IDevicePropList[];
}
interface IDevicePropList {
    label: string;
    value: string;
}
const props = defineProps({
    handItemInfo: {
        type: Object,
        default: () => { }
    },
    projectId: {
        type: String,
        default: ''
    }
});
const dialogVisible = ref(false);
const bind_devices = ref<IBindDevice[]>([]);
const device_list = ref<IDeviceList[]>([]);
const ruleFormRef = ref();
const rules = reactive({
    device_id: {
        required: true,
        message: '请选择设备',
        trigger: 'change'
    },
    device_prop: [{ required: true, message: '请选择设备属性', trigger: 'change' }],
    bind_node_prop: [{ required: true, message: '请选择图形属性', trigger: 'change' }]
});
const getBindInfo = () => {
    Promise.all([getProject(props.projectId), listSvgnode({ projectId: props.projectId,svgNodeId: props.handItemInfo.id})]).then(res => {
        console.log(res, 35, props.handItemInfo);
        device_list.value = res[0].data.deviceList.map(m => {
            return {
                id: String(m.deviceId),
                name: String(m.deviceName),
                prop_list: m.deviceDictList.map(md => md)
            }
        });
        bind_devices.value = res[1].data.map(m => {
            return {
                bind_node_id: m.svgNodeId,
                bind_node_prop: m.svgNodeProp,
                device_id: String(m.deviceId),
                device_prop: m.deviceProp
            }
        })
    })
}
const onConfigClick = () => {
    console.log('点击了配置按钮，查询当前图形目前已经绑定的设备');
    getBindInfo();
    dialogVisible.value = true;
}
const getBindDeviceProp = (device_id: string) => {
    return device_list.value.find((f) => f.id == device_id)?.prop_list ?? [];
};
const getHandItemProp = () => {
    let temp_prop: { label: string; value: string }[] = [];
    console.log(props.handItemInfo.props);
    
    for (const key in props.handItemInfo.props) {
        temp_prop.push({
            label: props.handItemInfo.props[key].title,
            value: `props.${key}.val`
        });
    }
    return temp_prop;
};
const onAddClick = (btn_state: boolean) => {
    if (btn_state) {
        ElMessage.error('必须先完成上一个步骤！');
        return;
    }
    bind_devices.value.push({
        bind_node_id: props.handItemInfo.id,
        bind_node_prop: '',
        device_id: '',
        device_prop: '',
        bind_btn_state: true
    });
};
const onDeviceBind = (type: number, data: IBindDevice, index: number) => {
    ruleFormRef.value?.validate((valid, fields) => {
        if (valid) {
            beginDeviceBind(type, data)
        } else {
            //判断要操作的和报错的是不是一条记录
            let canBind = true;
            for (const key in fields) {
                if (key.split('.')[0] == `[${index}]`) {
                    canBind = false;
                }
            }
            if (canBind) {
                beginDeviceBind(type, data)
                return;
            }
            console.log('error submit!', fields);
        }
    });
};
const beginDeviceBind = (type, data) => {
    console.log('触发了设备绑定', type, data);
    if (type == 1) {
        //绑定
        addSvgnode({
            projectId: props.projectId,
            deviceId: data.device_id,
            svgNodeId: data.bind_node_id,
            svgNodeProp: data.bind_node_prop,
            deviceProp: data.device_prop
        }).then(res => {
            ElMessage.success('绑定成功');
            getBindInfo();
        });

    }
    else {
        //解绑
        unBindSvgnode({
            projectId: props.projectId,
            deviceId: data.device_id,
            svgNodeId: data.bind_node_id,
            svgNodeProp: data.bind_node_prop,
            deviceProp: data.device_prop
        }).then(res => {
            ElMessage.success('解除绑定成功');
            getBindInfo();
        });
    }
};
</script>