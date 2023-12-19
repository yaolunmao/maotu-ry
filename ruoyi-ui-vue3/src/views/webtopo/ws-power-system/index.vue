<template>
    <div>
        <div style="display: flex;justify-content:center">
            <div>
                <p style="margin-top: 40px;">点击设置之后回到项目预览观察组件状态</p>
            </div>
        </div>
        <el-row justify="center">
            <el-col class="col-main" :span="4" :offset="index % 5 == 0 ? 0 : 1" v-for="(item, index) in data"
                :key="item.device_id">
                <el-card class="box-card">
                    <template #header>
                        <div class="card-header">
                            <span>{{ item.title }}</span>
                            <el-button type="success" plain @click="setClick(item)">点击设置</el-button>
                        </div>
                    </template>
                    <el-form label-width="80px">
                        <el-form-item :label="prop_item.type == 'onOff' ? '开关状态' : '电压值'" v-for="prop_item in item.props"
                            :key="prop_item.type">
                            <el-switch v-model="prop_item.val" v-if="prop_item.type == 'onOff'" />
                            <el-input-number v-model="prop_item.val" v-else />
                        </el-form-item>
                    </el-form>
                </el-card></el-col>
        </el-row>

    </div>
</template>
<script setup>
import { ref } from "vue";
import { simulationDeviceInfoApi } from "@/api/webtopo/websocket";
import { ElMessage } from "element-plus";
const route = useRoute();
const current_project_id = ref('');
current_project_id.value = route.query.project_id;
const data = ref([
    {
        device_id: 1,
        type: 1,
        title: "1号断路器",
        props: [{
            type: "onOff",
            val: false
        }, {
            type: "voltage",
            val: 0
        }]
    }, {
        device_id: 2,
        type: 1,
        title: "2号断路器",
        props: [{
            type: "onOff",
            val: false
        }, {
            type: "voltage",
            val: 0
        }]
    }, {
        device_id: 3,
        type: 1,
        title: "3号断路器",
        props: [{
            type: "onOff",
            val: false
        }, {
            type: "voltage",
            val: 0
        }]
    }, {
        device_id: 4,
        type: 1,
        title: "4号断路器",
        props: [{
            type: "onOff",
            val: false
        }, {
            type: "voltage",
            val: 0
        }]
    }, {
        device_id: 5,
        type: 1,
        title: "5号断路器",
        props: [{
            type: "onOff",
            val: false
        }, {
            type: "voltage",
            val: 0
        }]
    }
    , {
        device_id: 6,
        type: 2,
        title: "6号断路器",
        props: [{
            type: "onOff",
            val: false
        }]
    }, {
        device_id: 7,
        type: 2,
        title: "7号断路器",
        props: [{
            type: "onOff",
            val: false
        }]
    }, {
        device_id: 8,
        type: 2,
        title: "8号断路器",
        props: [{
            type: "onOff",
            val: false
        }]
    }, {
        device_id: 9,
        type: 2,
        title: "9号断路器",
        props: [{
            type: "onOff",
            val: false
        }]
    }, {
        device_id: 10,
        type: 2,
        title: "10号断路器",
        props: [{
            type: "onOff",
            val: false
        }]
    }
]);
const setClick = (item) => {
    const post_data={
        projectId:current_project_id.value,
        deviceId:item.device_id,
        props:item.props
    }
    console.log(post_data, 135);
    simulationDeviceInfoApi(post_data).then(()=>{
        ElMessage.success('已设置设备状态，请返回预览项目页签查看变化')
    });
}
</script>
<style scoped>
.card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.col-main {
    margin-top: 100px;
}
</style>