<template>
  <router-view />
</template>

<script setup>
import useSettingsStore from '@/store/modules/settings'
import { handleThemeStyle } from '@/utils/theme'
import { leftAsideStore } from "maotu";
const modulesFiles = import.meta.glob("/public/svgs/test/**.svg", { eager: true, as: 'raw' })
const register_config = [{
  id: 'ws-state',
  title: 'websocket连接状态',
  type: 'custom-svg',
  thumbnail: '/svgs/ws-state.svg',
  props: {
    state: {
      type: 'switch',
      val: false,
      title: '已连接'
    }
  }
},{
  id: 'circuit-breaker-voltage',
  title: 'A牌断路器',
  type: 'custom-svg',
  thumbnail: '/svgs/circuit-breaker-voltage.svg',
  props: {
    state: {
      type: 'switch',
      val: false,
      title: '开关'
    },
    voltage: {
      type: 'number',
      val: 0,
      title: '电压'
    }
  }
},
{
  id: 'circuit-breaker-b',
  title: 'B牌断路器',
  type: 'custom-svg',
  thumbnail: '/svgs/circuit-breaker-b.svg',
  props: {
    state: {
      type: 'switch',
      val: false,
      title: '开关'
    }
  }
}];
for (const key in modulesFiles) {
  //根据路径获取svg文件名
  const name = key.split("/").pop().split(".")[0];
  if (name == '电阻') {
    register_config.push({
      id: name,
      title: name,
      type: 'svg',
      thumbnail: key.replace('/public', ''),
      svg: modulesFiles[key],
      props: {
        stroke: {
          type: 'color',
          val: '#FF0000',
          title: '颜色'
        }
      }
    })
  }
  else {
    register_config.push({
      id: name,
      title: name,
      type: 'svg',
      thumbnail: key.replace('/public', ''),
      svg: modulesFiles[key],
      props: {
        fill: {
          type: 'color',
          val: '#FF0000',
          title: '填充色'
        }
      }
    })
  }

}
leftAsideStore.registerConfig('演示用svg', register_config);
onMounted(() => {
  nextTick(() => {
    // 初始化主题样式
    handleThemeStyle(useSettingsStore().theme)
  })
})
</script>
<style>
.el-menu-item * {
  vertical-align: middle !important;
}

svg,
img {
  display: inline-block !important;
  vertical-align: middle !important;
}
</style>
