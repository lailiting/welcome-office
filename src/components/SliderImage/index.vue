<script setup>
import { onMounted, ref, onBeforeUnmount } from "vue";
import SliderItem from "./SliderItem.vue"
import SliderDot from "./SliderDot.vue";
const props = defineProps({
  imageData: Array
})
let sliderTime = null
onMounted(() => {
  if(props.imageData.length > 1){
    sliderAutoplay()
  }
})
const sliderAutoplay = () => {
  sliderTime = setInterval(() => {
    if (activeIndex.value >= props.imageData.length - 1) {
      activeIndex.value = 0;
    } else {
      activeIndex.value += 1;
    }
  }, 2000)
}
onBeforeUnmount(() => {
  _clearIntervalFn();
});

function _clearIntervalFn() {
  clearInterval(sliderTime);
  sliderTime = null;
}
const activeIndex = ref(0)

const changeDot = (index) => {
  activeIndex.value = index
  console.log(activeIndex.value)
}
const silderMouseEnter = () => {
  _clearIntervalFn();
}
const sliderMouseLeave = () => {
  sliderAutoplay()
}
</script>

<template>
  <div class="slider-box" @mouseenter="silderMouseEnter" @mouseleave="sliderMouseLeave">
    <template v-for="(item, index) in imageData" :key="item">
      <SliderItem :activeIndex="activeIndex" :index="index" :src="item"></SliderItem>
    </template>
    <div class="slider-dot-box" v-if="imageData.length >1">
      <template v-for="(item, index) in imageData" :key="item.src">
        <SliderDot :activeIndex="activeIndex" :index="index" @change-dot="changeDot"></SliderDot>
      </template>
    </div>
  </div>
</template>

<style>
.slider-box {
  width: 375px;
  height: 250px;
  position: relative;
  overflow: hidden;
  margin: 0 100px;
}

.slider-dot-box {
  position: absolute;
  display: flex;
  bottom: 15px;
  right: 20px;
}

@media screen and (max-width: 800px) {
  .slider-box{
    margin: 0 auto;
    width: 300px;
    height: 200px;
  }
}
</style>