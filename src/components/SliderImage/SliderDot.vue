<script setup>
const props = defineProps({
  activeIndex:Number,
  index:Number
})
 const emit= defineEmits(['change-dot'])
  
  const clickDot = () => {
    emit('change-dot',props.index)
  }
</script>

<template>
  <div class="slider-dot" @click="clickDot" :class="activeIndex == index? 'active-dot' : ''">
  </div>
</template>

<style scoped>
.slider-dot{
  width:6px;
  height: 6px;
  background-color: rgb(154, 154, 154);
  margin: 4px;
  border-radius: 50%;
}
.active-dot{
  background-color:#79c621;
}
</style>