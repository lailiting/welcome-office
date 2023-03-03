<template>
    <p class="introce-text">{{showIntro}}</p>
</template>
<script lang='ts' setup>
import { reactive, toRefs, ref } from 'vue'

import { getData } from "../../utils/request"
let introduce = ref("")
let introStrindex = ref(0)
let showIntro = ref("")

//获取工作室介绍
const getIntroduce = async () => {
    try {
        let res = await getData("/api1/introduce/view", {
            type: "工作室介绍"
        })
        introduce.value = res.data.content
        //打字效果定时器

        let typeing = setInterval(() => {
            showIntro.value += introduce.value[introStrindex.value++]
            introStrindex.value >= introduce.value.length && clearInterval(typeing)
        }, 100)
    } catch (err) {
        console.log(err)
    }
}

getIntroduce()


</script>
<style lang = "less" scoped>
.introce-text {
    width: 400px;
    height: 110px;
    text-align: left;
    margin: 20px 20px;
}

.introce-text::after {
    content: "";
    display: inline-block;
    width: 2px;
    height: 1em;
    margin-bottom: -2px;
    margin-left: 2px;
    background-color: #333;
    animation: blink-caret .5s step-end infinite;
}

@keyframes blink-caret {
    50% {
        opacity: 0;
    }
}
</style>
