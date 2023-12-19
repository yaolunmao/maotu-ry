<template>
  <svg width="50" height="50" xmlns="http://www.w3.org/2000/svg" version="1.1">
    <g>
      <circle
        cx="25"
        cy="25"
        r="25"
        :fill="props.state ? 'green' : 'red'"
        width="100"
        height="100"
        id="svg_1"
        stroke="null"
      />
    </g>
  </svg>
</template>
<script setup lang="ts">
const props = defineProps({
  state: {
    type: Boolean,
    default: false
  }
});
</script>
