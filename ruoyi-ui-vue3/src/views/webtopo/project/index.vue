<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目名称" prop="projectName">
        <el-input v-model="queryParams.projectName" placeholder="请输入项目名称" clearable @keyup.enter="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <div class="toolbar">
        <el-tooltip effect="dark" content="新增" placement="top">
          <el-button plain circle icon="Plus" @click="handleAdd" style="margin-right: 10px;"></el-button>
        </el-tooltip>
        <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
      </div>
    </el-row>
    <el-row>
      <el-col v-for="(item, index) in projectList" :key="item.projectId" :span="4" :offset="index % 5 !== 0 ? 1 : 0"
        style="margin-bottom: 15px;">
        <el-card :body-style="{ padding: '10px' }">
          <template #header>
            <div class="card-header">
              <span>{{ item.projectName }}</span>
            </div>
          </template>
          <div style="display: flex;align-items: center;justify-content: center;" title="点击预览" @click="toPreview(item)">
            <img :src="item.thumbnail" class="image" />
          </div>
          <div style="display: flex;margin-top: 10px;justify-content: flex-end;">
            <el-link type="primary" @click="handleEdit(item)" style="margin-right: 8px;">设计</el-link>
            <el-link type="success" @click="handleUpdate(item)" style="margin-right: 8px;">修改</el-link>
            <el-link type="danger" @click="handleDelete(item)">删除</el-link>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <!-- <el-table v-loading="loading" :data="projectList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="项目id" align="center" prop="id" />
      <el-table-column label="项目名称" align="center" prop="projectName" />
      <el-table-column label="缩略图" align="center" prop="thumbnail" />
      <el-table-column label="数据模型" align="center" prop="dataModel" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['webtopo:project:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
            v-hasPermi="['webtopo:project:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    {{ projectList }} -->
    <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize" @pagination="getList" />

    <!-- 添加或修改项目列表对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="projectRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="关联设备">
          <el-select-v2 v-model="select_device_list" :options="device_options" placeholder="请选择关联设备"
            style="width: 240px" multiple filterable />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Project">
import { listProject, getProject, delProject, addProject, updateProject } from "@/api/webtopo/project";
import { listDeviceAll } from "@/api/webtopo/device";
import { ElMessage } from 'element-plus';
const router = useRouter();
const { proxy } = getCurrentInstance();

const projectList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const device_options = ref([]);
const select_device_list = ref([]);
const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    projectName: null,
  },
  rules: {
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询项目列表列表 */
function getList() {
  loading.value = true;
  listProject(queryParams.value).then(response => {
    projectList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    projectId: null,
    projectName: null,
    thumbnail: null,
    dataModel: null,
    createBy: null,
    createTime: null,
    updateBy: null,
    updateTime: null,
    remark: null
  };
  proxy.resetForm("projectRef");
  select_device_list.value=[];
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加项目";
}
/**
 * 设计按钮操作
 * @param {*} row 
 */
function handleEdit(row) {
  const _id = row.projectId || ids.value;
  router.push({
      name: 'WebtopoEdit',
      query: {
        project_id:_id
      }
    });
}
function toPreview(row){
  const _id = row.projectId || ids.value;
  window.open(router.resolve({
      path: '/webtopoPreview',
      query: {
        project_id:_id
      }
    }).href);
}
/** 修改按钮操作 */
function handleUpdate(row) {
  console.log(row, 175);
  reset();
  const _id = row.projectId || ids.value
  getProject(_id).then(response => {
    form.value = response.data;
    select_device_list.value = response.data.deviceList.filter(f => f.projectId == row.projectId).map(m => m.deviceId);
    open.value = true;
    title.value = "修改项目";

  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["projectRef"].validate(valid => {
    if (valid) {
      form.value.deviceList = select_device_list.value.map(m => {
        return {
          projectId: form.value.projectId,
          deviceId: m
        }
      });
      if (form.value.projectId != null) {
        updateProject(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addProject(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.projectId || ids.value;
  proxy.$modal.confirm('是否确认删除"' + row.projectName + '"的数据项？').then(function () {
    return delProject(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => { });
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('webtopo/project/export', {
    ...queryParams.value
  }, `project_${new Date().getTime()}.xlsx`)
}

getList();
listDeviceAll().then(res => {
  console.log(res, 224);
  if (res.code != 200) {
    ElMessage.error(res.msg);
    return;
  }
  device_options.value = res.rows.map(m => {
    return {
      ...m,
      label: m.name,
      value: m.id
    }
  });
});
</script>
<style scoped>
.image {
  width: 150px;
  height: 150px;
  cursor: pointer;
}

.toolbar {
  display: flex;
  margin-left: auto;
  margin-right: 5px;
}
</style>
