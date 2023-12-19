import{T as G,d as de,r as g,u as pe,C as ce,K as me,f as r,H as Y,o as d,c as k,I as w,J as z,i as l,h as e,w as o,j as _e,L as F,k as v,M as Q,D as T,n as s,A as h,l as E,m as O,F as fe}from"./index-_GLIFr1R.js";import{g as be}from"./job-u1v0Jafe.js";function ge(V){return G({url:"/monitor/jobLog/list",method:"get",params:V})}function ve(V){return G({url:"/monitor/jobLog/"+V,method:"delete"})}function he(){return G({url:"/monitor/jobLog/clean",method:"delete"})}const we={class:"app-container"},je={key:0},ye={key:1},ke={class:"dialog-footer"},Ve=fe({name:"JobLog"}),Se=Object.assign(Ve,{setup(V){const{proxy:m}=de(),{sys_common_status:I,sys_job_group:R}=m.useDict("sys_common_status","sys_job_group"),U=g([]),j=g(!1),L=g(!0),C=g(!0),N=g([]),$=g(!0),S=g(0),y=g([]),J=pe(),A=ce({form:{},queryParams:{pageNum:1,pageSize:10,dictName:void 0,dictType:void 0,status:void 0}}),{queryParams:n,form:p,rules:Ce}=me(A);function f(){L.value=!0,ge(m.addDateRange(n.value,y.value)).then(u=>{U.value=u.rows,S.value=u.total,L.value=!1})}function H(){const u={path:"/monitor/job"};m.$tab.closeOpenPage(u)}function D(){n.value.pageNum=1,f()}function W(){y.value=[],m.resetForm("queryRef"),D()}function X(u){N.value=u.map(a=>a.jobLogId),$.value=!u.length}function Z(u){j.value=!0,p.value=u}function ee(u){m.$modal.confirm('是否确认删除调度日志编号为"'+N.value+'"的数据项?').then(function(){return ve(N.value)}).then(()=>{f(),m.$modal.msgSuccess("删除成功")}).catch(()=>{})}function oe(){m.$modal.confirm("是否确认清空所有调度日志数据项?").then(function(){return he()}).then(()=>{f(),m.$modal.msgSuccess("清空成功")}).catch(()=>{})}function le(){m.download("monitor/jobLog/export",{...n.value},`job_log_${new Date().getTime()}.xlsx`)}return(()=>{const u=J.params&&J.params.jobId;u!==void 0&&u!=0?be(u).then(a=>{n.value.jobName=a.data.jobName,n.value.jobGroup=a.data.jobGroup,f()}):f()})(),f(),(u,a)=>{const te=r("el-input"),i=r("el-form-item"),P=r("el-option"),q=r("el-select"),ae=r("el-date-picker"),b=r("el-button"),M=r("el-form"),c=r("el-col"),ne=r("right-toolbar"),B=r("el-row"),_=r("el-table-column"),K=r("dict-tag"),ue=r("el-table"),re=r("pagination"),se=r("el-dialog"),x=Y("hasPermi"),ie=Y("loading");return d(),k("div",we,[w(e(M,{model:l(n),ref:"queryRef",inline:!0,"label-width":"68px"},{default:o(()=>[e(i,{label:"任务名称",prop:"jobName"},{default:o(()=>[e(te,{modelValue:l(n).jobName,"onUpdate:modelValue":a[0]||(a[0]=t=>l(n).jobName=t),placeholder:"请输入任务名称",clearable:"",style:{width:"240px"},onKeyup:_e(D,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(i,{label:"任务组名",prop:"jobGroup"},{default:o(()=>[e(q,{modelValue:l(n).jobGroup,"onUpdate:modelValue":a[1]||(a[1]=t=>l(n).jobGroup=t),placeholder:"请选择任务组名",clearable:"",style:{width:"240px"}},{default:o(()=>[(d(!0),k(F,null,Q(l(R),t=>(d(),v(P,{key:t.value,label:t.label,value:t.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),e(i,{label:"执行状态",prop:"status"},{default:o(()=>[e(q,{modelValue:l(n).status,"onUpdate:modelValue":a[2]||(a[2]=t=>l(n).status=t),placeholder:"请选择执行状态",clearable:"",style:{width:"240px"}},{default:o(()=>[(d(!0),k(F,null,Q(l(I),t=>(d(),v(P,{key:t.value,label:t.label,value:t.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),e(i,{label:"执行时间",style:{width:"308px"}},{default:o(()=>[e(ae,{modelValue:l(y),"onUpdate:modelValue":a[3]||(a[3]=t=>T(y)?y.value=t:null),"value-format":"YYYY-MM-DD",type:"daterange","range-separator":"-","start-placeholder":"开始日期","end-placeholder":"结束日期"},null,8,["modelValue"])]),_:1}),e(i,null,{default:o(()=>[e(b,{type:"primary",icon:"Search",onClick:D},{default:o(()=>[s("搜索")]),_:1}),e(b,{icon:"Refresh",onClick:W},{default:o(()=>[s("重置")]),_:1})]),_:1})]),_:1},8,["model"]),[[z,l(C)]]),e(B,{gutter:10,class:"mb8"},{default:o(()=>[e(c,{span:1.5},{default:o(()=>[w((d(),v(b,{type:"danger",plain:"",icon:"Delete",disabled:l($),onClick:ee},{default:o(()=>[s("删除")]),_:1},8,["disabled"])),[[x,["monitor:job:remove"]]])]),_:1}),e(c,{span:1.5},{default:o(()=>[w((d(),v(b,{type:"danger",plain:"",icon:"Delete",onClick:oe},{default:o(()=>[s("清空")]),_:1})),[[x,["monitor:job:remove"]]])]),_:1}),e(c,{span:1.5},{default:o(()=>[w((d(),v(b,{type:"warning",plain:"",icon:"Download",onClick:le},{default:o(()=>[s("导出")]),_:1})),[[x,["monitor:job:export"]]])]),_:1}),e(c,{span:1.5},{default:o(()=>[e(b,{type:"warning",plain:"",icon:"Close",onClick:H},{default:o(()=>[s("关闭")]),_:1})]),_:1}),e(ne,{showSearch:l(C),"onUpdate:showSearch":a[4]||(a[4]=t=>T(C)?C.value=t:null),onQueryTable:f},null,8,["showSearch"])]),_:1}),w((d(),v(ue,{data:l(U),onSelectionChange:X},{default:o(()=>[e(_,{type:"selection",width:"55",align:"center"}),e(_,{label:"日志编号",width:"80",align:"center",prop:"jobLogId"}),e(_,{label:"任务名称",align:"center",prop:"jobName","show-overflow-tooltip":!0}),e(_,{label:"任务组名",align:"center",prop:"jobGroup","show-overflow-tooltip":!0},{default:o(t=>[e(K,{options:l(R),value:t.row.jobGroup},null,8,["options","value"])]),_:1}),e(_,{label:"调用目标字符串",align:"center",prop:"invokeTarget","show-overflow-tooltip":!0}),e(_,{label:"日志信息",align:"center",prop:"jobMessage","show-overflow-tooltip":!0}),e(_,{label:"执行状态",align:"center",prop:"status"},{default:o(t=>[e(K,{options:l(I),value:t.row.status},null,8,["options","value"])]),_:1}),e(_,{label:"执行时间",align:"center",prop:"createTime",width:"180"},{default:o(t=>[E("span",null,h(u.parseTime(t.row.createTime)),1)]),_:1}),e(_,{label:"操作",align:"center","class-name":"small-padding fixed-width"},{default:o(t=>[w((d(),v(b,{link:"",type:"primary",icon:"View",onClick:xe=>Z(t.row)},{default:o(()=>[s("详细")]),_:2},1032,["onClick"])),[[x,["monitor:job:query"]]])]),_:1})]),_:1},8,["data"])),[[ie,l(L)]]),w(e(re,{total:l(S),page:l(n).pageNum,"onUpdate:page":a[5]||(a[5]=t=>l(n).pageNum=t),limit:l(n).pageSize,"onUpdate:limit":a[6]||(a[6]=t=>l(n).pageSize=t),onPagination:f},null,8,["total","page","limit"]),[[z,l(S)>0]]),e(se,{title:"调度日志详细",modelValue:l(j),"onUpdate:modelValue":a[8]||(a[8]=t=>T(j)?j.value=t:null),width:"700px","append-to-body":""},{footer:o(()=>[E("div",ke,[e(b,{onClick:a[7]||(a[7]=t=>j.value=!1)},{default:o(()=>[s("关 闭")]),_:1})])]),default:o(()=>[e(M,{model:l(p),"label-width":"100px"},{default:o(()=>[e(B,null,{default:o(()=>[e(c,{span:12},{default:o(()=>[e(i,{label:"日志序号："},{default:o(()=>[s(h(l(p).jobLogId),1)]),_:1}),e(i,{label:"任务名称："},{default:o(()=>[s(h(l(p).jobName),1)]),_:1})]),_:1}),e(c,{span:12},{default:o(()=>[e(i,{label:"任务分组："},{default:o(()=>[s(h(l(p).jobGroup),1)]),_:1}),e(i,{label:"执行时间："},{default:o(()=>[s(h(l(p).createTime),1)]),_:1})]),_:1}),e(c,{span:24},{default:o(()=>[e(i,{label:"调用方法："},{default:o(()=>[s(h(l(p).invokeTarget),1)]),_:1})]),_:1}),e(c,{span:24},{default:o(()=>[e(i,{label:"日志信息："},{default:o(()=>[s(h(l(p).jobMessage),1)]),_:1})]),_:1}),e(c,{span:24},{default:o(()=>[e(i,{label:"执行状态："},{default:o(()=>[l(p).status==0?(d(),k("div",je,"正常")):l(p).status==1?(d(),k("div",ye,"失败")):O("",!0)]),_:1})]),_:1}),e(c,{span:24},{default:o(()=>[l(p).status==1?(d(),v(i,{key:0,label:"异常信息："},{default:o(()=>[s(h(l(p).exceptionInfo),1)]),_:1})):O("",!0)]),_:1})]),_:1})]),_:1},8,["model"])]),_:1},8,["modelValue"])])}}});export{Se as default};
