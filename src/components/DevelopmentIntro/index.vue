<script setup>
import DevIntroItem from './DevIntroItem.vue';
// import { reactive } from 'vue';

const devlopmentData = [{
    image: "#@",
    title: "PHP",
    content: "文字是人类用符号记录表达信息以传之久远的方式和工具。现代文字大多是记录语言的工具。人类往往先有口头的语言后产生书面文字，很多小语种，有语言但没有文字。文字的不同体现了国家和民族的书面表达的方式和思维不同。文字使人类进入有历史记录的文明社会。"
},
{
    image: "#@23",
    title: "PHP1",
    content: "文字是人类用符号记录表达信息以传之久远的方式和工具。现代文字大多是记录语言的工具。人类往往先有口头的语言后产生书面文字，很多小语种，有语言但没有文字。文字的不同体现了国家和民族的书面表达的方式和思维不同。文字使人类进入有历史记录的文明社会。"
},
{
    image: "#@",
    title: "PHP2",
    content: "文字是人类用符号记录表达信息以传之久远的方式和工具。现代文字大多是记录语言的工具。人类往往先有口头的语言后产生书面文字，很多小语种，有语言但没有文字。文字的不同体现了国家和民族的书面表达的方式和思维不同。文字使人类进入有历史记录的文明社会。"
}
]
</script>

<template>
    <div>
        <template v-for="(item, index) in devlopmentData" :key="item.title">
            <DevIntroItem :devData="item" :index="index"></DevIntroItem>
        </template>
    </div>
</template>

<style scoped>
</style>