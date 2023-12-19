import{T as C,d as fe,r as m,C as _e,K as ye,f as a,H as M,o as r,c as N,I as b,J as O,i as n,h as e,w as l,j as G,L as $,k as f,M as q,n as c,D as W,A as X,l as Y,F as ge}from"./index-_GLIFr1R.js";function ve(d){return C({url:"/system/notice/list",method:"get",params:d})}function be(d){return C({url:"/system/notice/"+d,method:"get"})}function he(d){return C({url:"/system/notice",method:"post",data:d})}function we(d){return C({url:"/system/notice",method:"put",data:d})}function Ve(d){return C({url:"/system/notice/"+d,method:"delete"})}const Te={class:"app-container"},Ce={class:"dialog-footer"},ke=ge({name:"Notice"}),Ne=Object.assign(ke,{setup(d){const{proxy:_}=fe(),{sys_notice_status:K,sys_notice_type:U}=_.useDict("sys_notice_status","sys_notice_type"),P=m([]),y=m(!1),x=m(!0),k=m(!0),I=m([]),F=m(!0),L=m(!0),B=m(0),D=m(""),Z=_e({form:{},queryParams:{pageNum:1,pageSize:10,noticeTitle:void 0,createBy:void 0,status:void 0},rules:{noticeTitle:[{required:!0,message:"公告标题不能为空",trigger:"blur"}],noticeType:[{required:!0,message:"公告类型不能为空",trigger:"change"}]}}),{queryParams:s,form:i,rules:ee}=ye(Z);function h(){x.value=!0,ve(s.value).then(u=>{P.value=u.rows,B.value=u.total,x.value=!1})}function te(){y.value=!1,R()}function R(){i.value={noticeId:void 0,noticeTitle:void 0,noticeType:void 0,noticeContent:void 0,status:"0"},_.resetForm("noticeRef")}function S(){s.value.pageNum=1,h()}function le(){_.resetForm("queryRef"),S()}function ne(u){I.value=u.map(o=>o.noticeId),F.value=u.length!=1,L.value=!u.length}function oe(){R(),y.value=!0,D.value="添加公告"}function z(u){R();const o=u.noticeId||I.value;be(o).then(V=>{i.value=V.data,y.value=!0,D.value="修改公告"})}function ae(){_.$refs.noticeRef.validate(u=>{u&&(i.value.noticeId!=null?we(i.value).then(o=>{_.$modal.msgSuccess("修改成功"),y.value=!1,h()}):he(i.value).then(o=>{_.$modal.msgSuccess("新增成功"),y.value=!1,h()}))})}function E(u){const o=u.noticeId||I.value;_.$modal.confirm('是否确认删除公告编号为"'+o+'"的数据项？').then(function(){return Ve(o)}).then(()=>{h(),_.$modal.msgSuccess("删除成功")}).catch(()=>{})}return h(),(u,o)=>{const V=a("el-input"),g=a("el-form-item"),Q=a("el-option"),j=a("el-select"),p=a("el-button"),A=a("el-form"),w=a("el-col"),ie=a("right-toolbar"),H=a("el-row"),v=a("el-table-column"),J=a("dict-tag"),ue=a("el-table"),se=a("pagination"),re=a("el-radio"),de=a("el-radio-group"),ce=a("el-dialog"),T=M("hasPermi"),pe=M("loading");return r(),N("div",Te,[b(e(A,{model:n(s),ref:"queryRef",inline:!0},{default:l(()=>[e(g,{label:"公告标题",prop:"noticeTitle"},{default:l(()=>[e(V,{modelValue:n(s).noticeTitle,"onUpdate:modelValue":o[0]||(o[0]=t=>n(s).noticeTitle=t),placeholder:"请输入公告标题",clearable:"",style:{width:"200px"},onKeyup:G(S,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(g,{label:"操作人员",prop:"createBy"},{default:l(()=>[e(V,{modelValue:n(s).createBy,"onUpdate:modelValue":o[1]||(o[1]=t=>n(s).createBy=t),placeholder:"请输入操作人员",clearable:"",style:{width:"200px"},onKeyup:G(S,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(g,{label:"类型",prop:"noticeType"},{default:l(()=>[e(j,{modelValue:n(s).noticeType,"onUpdate:modelValue":o[2]||(o[2]=t=>n(s).noticeType=t),placeholder:"公告类型",clearable:"",style:{width:"200px"}},{default:l(()=>[(r(!0),N($,null,q(n(U),t=>(r(),f(Q,{key:t.value,label:t.label,value:t.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),e(g,null,{default:l(()=>[e(p,{type:"primary",icon:"Search",onClick:S},{default:l(()=>[c("搜索")]),_:1}),e(p,{icon:"Refresh",onClick:le},{default:l(()=>[c("重置")]),_:1})]),_:1})]),_:1},8,["model"]),[[O,n(k)]]),e(H,{gutter:10,class:"mb8"},{default:l(()=>[e(w,{span:1.5},{default:l(()=>[b((r(),f(p,{type:"primary",plain:"",icon:"Plus",onClick:oe},{default:l(()=>[c("新增")]),_:1})),[[T,["system:notice:add"]]])]),_:1}),e(w,{span:1.5},{default:l(()=>[b((r(),f(p,{type:"success",plain:"",icon:"Edit",disabled:n(F),onClick:z},{default:l(()=>[c("修改")]),_:1},8,["disabled"])),[[T,["system:notice:edit"]]])]),_:1}),e(w,{span:1.5},{default:l(()=>[b((r(),f(p,{type:"danger",plain:"",icon:"Delete",disabled:n(L),onClick:E},{default:l(()=>[c("删除")]),_:1},8,["disabled"])),[[T,["system:notice:remove"]]])]),_:1}),e(ie,{showSearch:n(k),"onUpdate:showSearch":o[3]||(o[3]=t=>W(k)?k.value=t:null),onQueryTable:h},null,8,["showSearch"])]),_:1}),b((r(),f(ue,{data:n(P),onSelectionChange:ne},{default:l(()=>[e(v,{type:"selection",width:"55",align:"center"}),e(v,{label:"序号",align:"center",prop:"noticeId",width:"100"}),e(v,{label:"公告标题",align:"center",prop:"noticeTitle","show-overflow-tooltip":!0}),e(v,{label:"公告类型",align:"center",prop:"noticeType",width:"100"},{default:l(t=>[e(J,{options:n(U),value:t.row.noticeType},null,8,["options","value"])]),_:1}),e(v,{label:"状态",align:"center",prop:"status",width:"100"},{default:l(t=>[e(J,{options:n(K),value:t.row.status},null,8,["options","value"])]),_:1}),e(v,{label:"创建者",align:"center",prop:"createBy",width:"100"}),e(v,{label:"创建时间",align:"center",prop:"createTime",width:"100"},{default:l(t=>[Y("span",null,X(u.parseTime(t.row.createTime,"{y}-{m}-{d}")),1)]),_:1}),e(v,{label:"操作",align:"center","class-name":"small-padding fixed-width"},{default:l(t=>[b((r(),f(p,{link:"",type:"primary",icon:"Edit",onClick:me=>z(t.row)},{default:l(()=>[c("修改")]),_:2},1032,["onClick"])),[[T,["system:notice:edit"]]]),b((r(),f(p,{link:"",type:"primary",icon:"Delete",onClick:me=>E(t.row)},{default:l(()=>[c("删除")]),_:2},1032,["onClick"])),[[T,["system:notice:remove"]]])]),_:1})]),_:1},8,["data"])),[[pe,n(x)]]),b(e(se,{total:n(B),page:n(s).pageNum,"onUpdate:page":o[4]||(o[4]=t=>n(s).pageNum=t),limit:n(s).pageSize,"onUpdate:limit":o[5]||(o[5]=t=>n(s).pageSize=t),onPagination:h},null,8,["total","page","limit"]),[[O,n(B)>0]]),e(ce,{title:n(D),modelValue:n(y),"onUpdate:modelValue":o[10]||(o[10]=t=>W(y)?y.value=t:null),width:"780px","append-to-body":""},{footer:l(()=>[Y("div",Ce,[e(p,{type:"primary",onClick:ae},{default:l(()=>[c("确 定")]),_:1}),e(p,{onClick:te},{default:l(()=>[c("取 消")]),_:1})])]),default:l(()=>[e(A,{ref:"noticeRef",model:n(i),rules:n(ee),"label-width":"80px"},{default:l(()=>[e(H,null,{default:l(()=>[e(w,{span:12},{default:l(()=>[e(g,{label:"公告标题",prop:"noticeTitle"},{default:l(()=>[e(V,{modelValue:n(i).noticeTitle,"onUpdate:modelValue":o[6]||(o[6]=t=>n(i).noticeTitle=t),placeholder:"请输入公告标题"},null,8,["modelValue"])]),_:1})]),_:1}),e(w,{span:12},{default:l(()=>[e(g,{label:"公告类型",prop:"noticeType"},{default:l(()=>[e(j,{modelValue:n(i).noticeType,"onUpdate:modelValue":o[7]||(o[7]=t=>n(i).noticeType=t),placeholder:"请选择"},{default:l(()=>[(r(!0),N($,null,q(n(U),t=>(r(),f(Q,{key:t.value,label:t.label,value:t.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1})]),_:1}),e(w,{span:24},{default:l(()=>[e(g,{label:"状态"},{default:l(()=>[e(de,{modelValue:n(i).status,"onUpdate:modelValue":o[8]||(o[8]=t=>n(i).status=t)},{default:l(()=>[(r(!0),N($,null,q(n(K),t=>(r(),f(re,{key:t.value,label:t.value},{default:l(()=>[c(X(t.label),1)]),_:2},1032,["label"]))),128))]),_:1},8,["modelValue"])]),_:1})]),_:1}),e(w,{span:24},{default:l(()=>[e(g,{label:"内容"},{default:l(()=>[e(V,{rows:6,type:"textarea",placeholder:"请输入内容",modelValue:n(i).noticeContent,"onUpdate:modelValue":o[9]||(o[9]=t=>n(i).noticeContent=t)},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}});export{Ne as default};
