<script setup>

</script>

<template>
    <div class="direction-intro">
        <div class="direction-box">
            <img src="../assets/qianduan.png">
            <h3>前端</h3>
            <p>前端开发是创建Web页面或app等前端界面呈现给用户的过程。俗话就是通过UI设计出的图片，通过一系列前端技术把图片展现出来的过程。</p>
        </div>
        <div class="direction-box">
            <img src="../assets/houduan.png">
            <h3>后端</h3>
            <p>后端开发主要做的就是逻辑功能等模板，用户是看不见的。通俗来说就是后端是实现功能的，比如登录、注册等功能。</p>
        </div>
        <div class="direction-box">
            <img src="../assets/ui.png">
            <h3>UI</h3>
            <p>UI设计（或称界面设计）是指对软件的人机交互、操作逻辑界面美观的整体设计。通俗来说差不多就是设计页面图片。</p>
        </div>
    </div>
</template>

<style>
.direction-intro {
    display: grid;
    grid-template-columns: repeat(auto-fit, 32%);
    grid-gap: 10px;
    /* margin: 15px 0; */
}
.direction-box {
    width: 24vw;
    float: left;
    margin-left: 4vw;
}

img {
    max-width: 100%;
    max-height: 100%;
}

.direction-intro::after {
    content: '.';
    display: block;
    clear: both;
    overflow: hidden;
    height: 0;

}
</style>