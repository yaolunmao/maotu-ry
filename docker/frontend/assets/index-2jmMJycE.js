import{_ as le,a as oe,d as ae,r as u,C as ne,K as re,a6 as se,f as r,o as N,c as B,I as L,J as D,i as o,h as t,w as a,j as ue,n as f,D as I,l as _,L as ce,A as ie,k as de,M as pe,F as me}from"./index-_GLIFr1R.js";import{l as fe,g as _e,u as ve,a as ge,d as he}from"./project-J1lw65wD.js";import{b as ye}from"./device-odJQDp9N.js";const je={class:"app-container"},be={class:"toolbar"},ke={class:"card-header"},xe=["onClick"],we=["src"],Ce={style:{display:"flex","margin-top":"10px","justify-content":"flex-end"}},Ve={class:"dialog-footer"},Ne=me({name:"Project"}),Ie=Object.assign(Ne,{setup(Se){const S=oe(),{proxy:p}=ae(),P=u([]),d=u(!1),R=u(!0),y=u(!0),j=u([]);u(!0),u(!0);const b=u(0),k=u(""),U=u([]),v=u([]),F=ne({form:{},queryParams:{pageNum:1,pageSize:10,projectName:null},rules:{}}),{queryParams:c,form:s,rules:E}=re(F);function m(){R.value=!0,fe(c.value).then(n=>{P.value=n.rows,b.value=n.total,R.value=!1})}function K(){d.value=!1,x()}function x(){s.value={projectId:null,projectName:null,thumbnail:null,dataModel:null,createBy:null,createTime:null,updateBy:null,updateTime:null,remark:null},p.resetForm("projectRef"),v.value=[]}function w(){c.value.pageNum=1,m()}function T(){p.resetForm("queryRef"),w()}function z(){x(),d.value=!0,k.value="添加项目"}function A(n){const e=n.projectId||j.value;S.push({name:"WebtopoEdit",query:{project_id:e}})}function M(n){const e=n.projectId||j.value;window.open(S.resolve({path:"/webtopoPreview",query:{project_id:e}}).href)}function Q(n){console.log(n,175),x();const e=n.projectId||j.value;_e(e).then(g=>{s.value=g.data,v.value=g.data.deviceList.filter(i=>i.projectId==n.projectId).map(i=>i.deviceId),d.value=!0,k.value="修改项目"})}function J(){p.$refs.projectRef.validate(n=>{n&&(s.value.deviceList=v.value.map(e=>({projectId:s.value.projectId,deviceId:e})),s.value.projectId!=null?ve(s.value).then(e=>{p.$modal.msgSuccess("修改成功"),d.value=!1,m()}):ge(s.value).then(e=>{p.$modal.msgSuccess("新增成功"),d.value=!1,m()}))})}function O(n){const e=n.projectId||j.value;p.$modal.confirm('是否确认删除"'+n.projectName+'"的数据项？').then(function(){return he(e)}).then(()=>{m(),p.$modal.msgSuccess("删除成功")}).catch(()=>{})}return m(),ye().then(n=>{if(console.log(n,224),n.code!=200){se.error(n.msg);return}U.value=n.rows.map(e=>({...e,label:e.name,value:e.id}))}),(n,e)=>{const g=r("el-input"),i=r("el-form-item"),h=r("el-button"),$=r("el-form"),W=r("el-tooltip"),G=r("right-toolbar"),q=r("el-row"),C=r("el-link"),H=r("el-card"),X=r("el-col"),Y=r("pagination"),Z=r("el-select-v2"),ee=r("el-dialog");return N(),B("div",je,[L(t($,{model:o(c),ref:"queryRef",inline:!0,"label-width":"68px"},{default:a(()=>[t(i,{label:"项目名称",prop:"projectName"},{default:a(()=>[t(g,{modelValue:o(c).projectName,"onUpdate:modelValue":e[0]||(e[0]=l=>o(c).projectName=l),placeholder:"请输入项目名称",clearable:"",onKeyup:ue(w,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),t(i,null,{default:a(()=>[t(h,{type:"primary",icon:"Search",onClick:w},{default:a(()=>[f("搜索")]),_:1}),t(h,{icon:"Refresh",onClick:T},{default:a(()=>[f("重置")]),_:1})]),_:1})]),_:1},8,["model"]),[[D,o(y)]]),t(q,{gutter:10,class:"mb8"},{default:a(()=>[_("div",be,[t(W,{effect:"dark",content:"新增",placement:"top"},{default:a(()=>[t(h,{plain:"",circle:"",icon:"Plus",onClick:z,style:{"margin-right":"10px"}})]),_:1}),t(G,{showSearch:o(y),"onUpdate:showSearch":e[1]||(e[1]=l=>I(y)?y.value=l:null),onQueryTable:m},null,8,["showSearch"])])]),_:1}),t(q,null,{default:a(()=>[(N(!0),B(ce,null,pe(o(P),(l,te)=>(N(),de(X,{key:l.projectId,span:4,offset:te%5!==0?1:0,style:{"margin-bottom":"15px"}},{default:a(()=>[t(H,{"body-style":{padding:"10px"}},{header:a(()=>[_("div",ke,[_("span",null,ie(l.projectName),1)])]),default:a(()=>[_("div",{style:{display:"flex","align-items":"center","justify-content":"center"},title:"点击预览",onClick:V=>M(l)},[_("img",{src:l.thumbnail,class:"image"},null,8,we)],8,xe),_("div",Ce,[t(C,{type:"primary",onClick:V=>A(l),style:{"margin-right":"8px"}},{default:a(()=>[f("设计")]),_:2},1032,["onClick"]),t(C,{type:"success",onClick:V=>Q(l),style:{"margin-right":"8px"}},{default:a(()=>[f("修改")]),_:2},1032,["onClick"]),t(C,{type:"danger",onClick:V=>O(l)},{default:a(()=>[f("删除")]),_:2},1032,["onClick"])])]),_:2},1024)]),_:2},1032,["offset"]))),128))]),_:1}),L(t(Y,{total:o(b),page:o(c).pageNum,"onUpdate:page":e[2]||(e[2]=l=>o(c).pageNum=l),limit:o(c).pageSize,"onUpdate:limit":e[3]||(e[3]=l=>o(c).pageSize=l),onPagination:m},null,8,["total","page","limit"]),[[D,o(b)>0]]),t(ee,{title:o(k),modelValue:o(d),"onUpdate:modelValue":e[7]||(e[7]=l=>I(d)?d.value=l:null),width:"500px","append-to-body":""},{footer:a(()=>[_("div",Ve,[t(h,{type:"primary",onClick:J},{default:a(()=>[f("确 定")]),_:1}),t(h,{onClick:K},{default:a(()=>[f("取 消")]),_:1})])]),default:a(()=>[t($,{ref:"projectRef",model:o(s),rules:o(E),"label-width":"80px"},{default:a(()=>[t(i,{label:"项目名称",prop:"projectName"},{default:a(()=>[t(g,{modelValue:o(s).projectName,"onUpdate:modelValue":e[4]||(e[4]=l=>o(s).projectName=l),placeholder:"请输入项目名称"},null,8,["modelValue"])]),_:1}),t(i,{label:"关联设备"},{default:a(()=>[t(Z,{modelValue:o(v),"onUpdate:modelValue":e[5]||(e[5]=l=>I(v)?v.value=l:null),options:o(U),placeholder:"请选择关联设备",style:{width:"240px"},multiple:"",filterable:""},null,8,["modelValue","options"])]),_:1}),t(i,{label:"备注",prop:"remark"},{default:a(()=>[t(g,{modelValue:o(s).remark,"onUpdate:modelValue":e[6]||(e[6]=l=>o(s).remark=l),type:"textarea",placeholder:"请输入内容"},null,8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}}),$e=le(Ie,[["__scopeId","data-v-8dd3a2fd"]]);export{$e as default};
