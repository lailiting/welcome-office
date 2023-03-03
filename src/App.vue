<script setup>

// import StudioMemberItem from './components/StudioMemberItem.vue';
import NavHeader from './components/NavHeader/index.vue';
import Footer from "./components/Footer/index.vue"
// import LoadingWait from "./components/LoadingWait/index.vue"
// import LoadingWait from './components/LoadingWait/index.vue';
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://vuejs.org/api/sfc-script-setup.html#script-setup
</script>

<template>
  <NavHeader></NavHeader>
  <div class="container">
    <router-view>
    </router-view>
  </div>
  <Footer/>
</template>

<style scoped>
.container {
  margin-top: 60px;
}

</style>
