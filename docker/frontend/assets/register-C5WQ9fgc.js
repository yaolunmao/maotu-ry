import{_ as R,a as E,d as I,r as f,f as i,o as h,c as y,h as e,w as t,i as s,j as v,k as U,l as u,m as z,p as B,n as N,x as S,y as T,s as M,t as $,v as j}from"./index-_GLIFr1R.js";const x=c=>($("data-v-ecb00528"),c=c(),j(),c),A={class:"register"},F=x(()=>u("h3",{class:"title"},"webtopo-pro",-1)),H={class:"register-code"},L=["src"],D={key:0},G={key:1},J={style:{float:"right"}},O=x(()=>u("div",{class:"el-register-footer"},[u("span",null,"Copyright © 2018-2023 ruoyi.vip All Rights Reserved.")],-1)),Q={__name:"register",setup(c){const b=E(),{proxy:k}=I(),o=f({username:"",password:"",confirmPassword:"",code:"",uuid:""}),C={username:[{required:!0,trigger:"blur",message:"请输入您的账号"},{min:2,max:20,message:"用户账号长度必须介于 2 和 20 之间",trigger:"blur"}],password:[{required:!0,trigger:"blur",message:"请输入您的密码"},{min:5,max:20,message:"用户密码长度必须介于 5 和 20 之间",trigger:"blur"}],confirmPassword:[{required:!0,trigger:"blur",message:"请再次输入您的密码"},{required:!0,validator:(l,r,a)=>{o.value.password!==r?a(new Error("两次输入的密码不一致")):a()},trigger:"blur"}],code:[{required:!0,trigger:"change",message:"请输入验证码"}]},V=f(""),p=f(!1),m=f(!0);function g(){k.$refs.registerRef.validate(l=>{l&&(p.value=!0,S(o.value).then(r=>{const a=o.value.username;T.alert("<font color='red'>恭喜你，您的账号 "+a+" 注册成功！</font>","系统提示",{dangerouslyUseHTMLString:!0,type:"success"}).then(()=>{b.push("/login")}).catch(()=>{})}).catch(()=>{p.value=!1,m&&w()}))})}function w(){M().then(l=>{m.value=l.captchaEnabled===void 0?!0:l.captchaEnabled,m.value&&(V.value="data:image/gif;base64,"+l.img,o.value.uuid=l.uuid)})}return w(),(l,r)=>{const a=i("svg-icon"),_=i("el-input"),d=i("el-form-item"),q=i("el-button"),K=i("router-link"),P=i("el-form");return h(),y("div",A,[e(P,{ref:"registerRef",model:s(o),rules:C,class:"register-form"},{default:t(()=>[F,e(d,{prop:"username"},{default:t(()=>[e(_,{modelValue:s(o).username,"onUpdate:modelValue":r[0]||(r[0]=n=>s(o).username=n),type:"text",size:"large","auto-complete":"off",placeholder:"账号"},{prefix:t(()=>[e(a,{"icon-class":"user",class:"el-input__icon input-icon"})]),_:1},8,["modelValue"])]),_:1}),e(d,{prop:"password"},{default:t(()=>[e(_,{modelValue:s(o).password,"onUpdate:modelValue":r[1]||(r[1]=n=>s(o).password=n),type:"password",size:"large","auto-complete":"off",placeholder:"密码",onKeyup:v(g,["enter"])},{prefix:t(()=>[e(a,{"icon-class":"password",class:"el-input__icon input-icon"})]),_:1},8,["modelValue","onKeyup"])]),_:1}),e(d,{prop:"confirmPassword"},{default:t(()=>[e(_,{modelValue:s(o).confirmPassword,"onUpdate:modelValue":r[2]||(r[2]=n=>s(o).confirmPassword=n),type:"password",size:"large","auto-complete":"off",placeholder:"确认密码",onKeyup:v(g,["enter"])},{prefix:t(()=>[e(a,{"icon-class":"password",class:"el-input__icon input-icon"})]),_:1},8,["modelValue","onKeyup"])]),_:1}),s(m)?(h(),U(d,{key:0,prop:"code"},{default:t(()=>[e(_,{size:"large",modelValue:s(o).code,"onUpdate:modelValue":r[3]||(r[3]=n=>s(o).code=n),"auto-complete":"off",placeholder:"验证码",style:{width:"63%"},onKeyup:v(g,["enter"])},{prefix:t(()=>[e(a,{"icon-class":"validCode",class:"el-input__icon input-icon"})]),_:1},8,["modelValue","onKeyup"]),u("div",H,[u("img",{src:s(V),onClick:w,class:"register-code-img"},null,8,L)])]),_:1})):z("",!0),e(d,{style:{width:"100%"}},{default:t(()=>[e(q,{loading:s(p),size:"large",type:"primary",style:{width:"100%"},onClick:B(g,["prevent"])},{default:t(()=>[s(p)?(h(),y("span",G,"注 册 中...")):(h(),y("span",D,"注 册"))]),_:1},8,["loading","onClick"]),u("div",J,[e(K,{class:"link-type",to:"/login"},{default:t(()=>[N("使用已有账户登录")]),_:1})])]),_:1})]),_:1},8,["model"]),O])}}},Y=R(Q,[["__scopeId","data-v-ecb00528"]]);export{Y as default};