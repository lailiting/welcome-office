<template>
    <div class="loading-box">
        <div class="animation"></div>
        <div class="light"></div>
        <div class="light"></div>
        <div class="shadow"></div>
    </div>
</template>
<script lang='ts' setup>
import { reactive, toRefs, ref } from 'vue'

</script>
<style lang = "less" scoped>
// 方块的动画
@keyframes box {
    0% {
        transform: translate(0, 0) rotate(45deg);
        border-radius: 10px 10px 110px 10px;
    }

    10% {
        border-radius: 10px 10px 10px 10px;
    }

    20% {
        transform: translate(0, -20px) rotate(45deg);
    }

    30% {
        transform: translate(0, -80px) rotate(45deg);
    }

    50% {
        transform: translate(0, -20px) rotate(45deg);
    }

    90% {
        border-radius: 10px 10px 10px 10px;
    }

    100% {
        transform: translate(0, 0) rotate(135deg);
        border-radius: 10px 110px 10px 10px;
    }
}

// 阴影的动画
@keyframes shadow {
    0% {
        transform: scale(1);
    }

    30% {
        transform: scale(0.6);
    }

    100% {
        transform: scale(1);
    }
}

// 光点的动画
@keyframes light {
    0% {
        transform: scale(1);
    }

    30% {
        transform: translate(0, -50px) scale(1);
        opacity: 0;
    }

    40% {
        transform: translate(0, -35px) scale(1.5);
        opacity: 1;
    }

    60% {
        opacity: 0;
        transform: translate(0, -15px) scale(2.5);

    }

    100% {
        transform: scale(1);
    }
}

// 放动画的box
.loading-box {
    position: relative;
    width: 50px;
    margin: 100px auto;


    // 方块
    .animation {
        width: 50px;
        height: 50px;
        background-color: skyblue;
        animation: box 1s linear infinite;
    }

    // 阴影
    .shadow {
        position: absolute;
        bottom: -10px;
        width: 50px;
        height: 20px;
        border-radius: 50%;
        margin: 0 auto;
        background-color: rgb(120, 186, 211, .3);
        z-index: -1;
        animation: shadow 1s linear infinite;
    }

    // 光
    .light {
        position: absolute;
        top: 0px;
        width: 50px;
        border-radius: 50%;
        border: 2px dashed skyblue;
        opacity: 0;
        animation: light 1s linear infinite;
    }
}
</style>
