<script setup>
defineProps({
  index: Number,
  src: String,
  activeIndex: Number
})
</script>

<template>
  <Transition name="slider">
    <div class="silder-item demo-image__lazy" v-if="index == activeIndex">
      <el-image :src="src" lazy style="width: 100%;height: 100%;" fit="cover"/>
    </div>
  </Transition>
</template>

<style scoped>

.silder-item {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

.silder-item img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 20px;
}

.slider-enter-active,
.slider-leave-active {
  transition: all 1s linear;
}

.slider-enter-active {
  transform: translateX(100%)
}

.slider-enter-to {
  transform: translateX(0);
}

.slider-leave-active {
  transform: translateX(0);
}

.slider-leave-to {
  transform: translateX(-100%)
}
</style>