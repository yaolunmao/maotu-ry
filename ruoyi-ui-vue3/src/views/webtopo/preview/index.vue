<template>
    <div v-loading="loading">
        <mt-preview  ref="MtPreviewRef" @on-event-call-back="onEventCallBack"></mt-preview>
    </div>
</template>
<script setup>
import { nextTick, ref } from "vue";
import { ElNotification, ElMessage } from "element-plus";
import { getProject } from "@/api/webtopo/project";
import { MtPreview } from 'maotu';
import 'maotu/dist/style.css';
// 源码版用户请构建完成之后放到lib文件夹下 然后这么引入
// import { MtPreview } from '@/lib/maotu.es';
// import '@/lib/style.css';
import { getToken } from '@/utils/auth';
import { simulationDeviceInfoApi } from "@/api/webtopo/websocket";
const route = useRoute();
const current_project_id = ref('');
current_project_id.value = route.query.project_id;
const ws = ref();
const MtPreviewRef = ref();
const loading = ref(true);
const onEventCallBack = (type, node_id, args1,args2,args3) => {
    console.log(type,node_id,args1,args2,22);
    if (type == "testRemoteControl") {
        ElMessage.success(`收到指令，控制${node_id}设备,附加消息是${args3}`);
        const post_data = {
                projectId: current_project_id.value,
                deviceId: args1,
                props: [{
                    type:'onOff',
                    val:!args2.props.state.val
                }]
            }
            simulationDeviceInfoApi(post_data);
    }
    else if (type == "testAllOpen") {
        args1.forEach(a1 => {
            const post_data = {
                projectId: current_project_id.value,
                deviceId: a1,
                props: [{
                    type:args2,
                    val:true
                }]
            }
            simulationDeviceInfoApi(post_data);
        });
    }
    else if (type == "testAllClose") {
        args1.forEach(a1 => {
            const post_data = {
                projectId: current_project_id.value,
                deviceId: a1,
                props: [{
                    type:args2,
                    val:false
                }]
            }
            simulationDeviceInfoApi(post_data);
        });
    }
    else {
        ElMessage.error(`未解析的指令:${type}`)
    }

}
getProject(current_project_id.value).then(res => {
    if (res.data.dataModel) {
        MtPreviewRef.value?.setImportJson(JSON.parse(res.data.dataModel));
    }
    else {
      // 如果之前没存过数据 那么就传初始化数据 这样可以自己设置画布大小等配置
      MtPreviewRef.value?.setImportJson(
        {
          "canvasCfg": {
            "width": 1920,
            "height": 1080,
            "scale": 1,
            "color": "",
            "img": "",
            "guide": true,
            "adsorp": true,
            "adsorp_diff": 3,
            "transform_origin": {
              "x": 0,
              "y": 0
            },
            "drag_offset": {
              "x": 0,
              "y": 0
            }
          },
          "gridCfg": {
            "enabled": true,
            "align": true,
            "size": 10
          },
          "json": []
        }
      )
    }
    loading.value=false;
    const host = import.meta.env.VITE_APP_SERVER_URL=='prod-host'?window.location.host:import.meta.env.VITE_APP_SERVER_URL;
    ws.value = new WebSocket(`ws://${host}/ws/${getToken()}`);
    ws.value.onopen = function (event) {
        console.log("websocket连接成功");
        const post_data = {
                projectId: current_project_id.value,
                deviceId: 11,
                props: [{
                    type:'ws_state',
                    val:true
                }]
            }
            simulationDeviceInfoApi(post_data);
    };
    ws.value.onmessage = function (event) {
        const data = JSON.parse(event.data);
        console.log('websocket收到消息', data);
        if (data.type == "setNodeAttr") {
            const set_attrs=data.msg.map(m=>{
                return{
                    id:m.id,
                    key:m.attr,
                    val:m.val
                }
            })
            MtPreviewRef.value.setItemAttrs(set_attrs);
        }
        else if (data.type == "setNodeAttrByID") {
            MtPreviewRef.value.setItemAttrByID(data.msg);
        }
        else {
            console.log("未定义的数据类型")
        }
    };
    ws.value.onclose = function (event) {
        console.log('连接已断开');
        const post_data = {
                projectId: current_project_id.value,
                deviceId: 11,
                props: [{
                    type:'ws_state',
                    val:false
                }]
            }
            simulationDeviceInfoApi(post_data);
    };
})
if(current_project_id.value==1){
    ElNotification({
    title: '设备模拟',
    dangerouslyUseHTMLString: true,
    message: `<div>请点击<a href="/ws_power_system?project_id=${current_project_id.value}" target="_blank"><strong>这里</strong></a>进行设备模拟</div>`,
    duration: 0,
});
setTimeout(() => {
    ElNotification({
        title: '设备控制',
        message: `B牌断路器配置了点击事件,请点击图纸上的B牌断路器查看`,
        duration: 0,
    });
}, 100);
setTimeout(() => {
    ElNotification({
        title: '电流与断路器同步',
        message: `在设备模拟页开启关闭断路器，观察电流动画`,
        duration: 0,
    });
}, 100);
}
else{
    ElNotification({
        title: '功能开发中敬请期待',
        message: `本页的实时数据暂未接入，如需查看演示请移步电力系统项目演示`,
        duration: 0,
    });
}



</script>