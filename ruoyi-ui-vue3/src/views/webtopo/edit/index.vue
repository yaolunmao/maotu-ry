<template>
  <div style="width: 100%;height: 100vh;" v-loading="loading">
    <mt-edit ref="MtEditRef" @on-return-click="onReturn" @on-save-click="onSave" @on-preview-click="onPreview">
      <template #deviceBind="{ item }">
        <!-- 只是提供了一个绑定设备的解决方案 自己的项目可以不必这么设计 本质上就是把设备属性和图形属性建立一个映射 详情请查阅maotu文档 -->
        <device-bind :hand-item-info="item" :project-id="current_project_id"></device-bind>
      </template>
    </mt-edit>
    <el-dialog v-model="dialogVisible" title="预览" fullscreen destroy-on-close>
      <mt-preview :export-json="export_json" ref="MtPreviewRef"></mt-preview>
    </el-dialog>
  </div>
</template>
<script setup>

import { ref } from "vue";
import { getProject, saveProject } from "@/api/webtopo/project";
import { listSvgnode, unBindSvgnode, addSvgnode } from "@/api/webtopo/svgnode"
import { ElMessage, ElDialog } from "element-plus";
import { MtEdit, MtPreview } from 'maotu';
import 'maotu/dist/style.css';
// 源码版用户请构建完成之后放到lib文件夹下 然后这么引入
// import { MtEdit, MtPreview } from '@/lib/maotu.es';
// import '@/lib/style.css';
import { useRouter, useRoute } from "vue-router";
import DeviceBind from './device-bind.vue';
const router = useRouter();
const route = useRoute();
const MtEditRef = ref();
const MtPreviewRef = ref();
const current_project_id = ref('');
const export_json = ref({});
const loading = ref(true);
const dialogVisible = ref(false);
const onReturn = () => {
  console.log('点击了返回按钮');
  router.go(-1);
};
const onPreview = (data_model) => {
  export_json.value = JSON.parse(JSON.stringify(data_model));
  dialogVisible.value = true;
};
const onSave = (data_model) => {
  console.log('点击了保存按钮，可以在此处将图存到数据库', data_model);
  saveProject({
    projectId: current_project_id.value,
    dataModel: JSON.stringify(data_model)
  }).then(res => {
    ElMessage.success('保存成功！');
  })
};
const getJsonInfo = () => {
  getProject(current_project_id.value).then(res => {
    if (res.data.dataModel) {
      MtEditRef.value?.setImportJson(JSON.parse(res.data.dataModel));
    }
    else {
      // 如果之前没存过数据 那么就传初始化数据 这样可以自己设置画布大小等配置
      MtEditRef.value?.setImportJson(
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

    loading.value = false;
  })
}

current_project_id.value = route.query.project_id;
getJsonInfo();
</script>