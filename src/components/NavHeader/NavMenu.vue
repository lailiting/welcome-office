<script setup>
import { ref } from 'vue'
// import DogIcon from '../CustomIcon/DogIcon/index.vue';


defineProps({
    MenuData: Array,
    Mode: String
})
const activeIndex = ref('/home')
activeIndex.value = sessionStorage.getItem('path')

const handleSelect = (key, keyPath) => {
    console.log(key, keyPath)
}
</script>

<template>
    <div class="out">
        <div class="el-nav-menu">
            <el-menu router :ellipsis="false" :default-active="activeIndex" class="el-menu-demo" :mode="Mode"
                @select="handleSelect">
                <template v-for="children in MenuData" :key="children.route">
                    <el-menu-item :index="children.route" v-if="!children.children">
                        <!-- <el-icon>
                            <component :is="children.icon"></component>
                        
                        </el-icon> -->
                        <template #title><el-icon><component :is="children.icon"></component></el-icon>{{ children.title }}</template>
                    </el-menu-item>
                    <el-sub-menu :index="children.route" v-else>
                        <template #title>
                            <el-icon>
                                <component :is="children.icon"></component>
                            </el-icon>
                            <span>{{ children.title }}</span>
                        </template>
                        <template v-for="item in children.children">
                            <el-menu-item :index="item.route" v-if="!item.children">
                                {{ item.title }}
                            </el-menu-item>
                            <el-sub-menu :index="item.route" v-else>
                                <template #title>
                                    <el-icon>
                                        <location />
                                    </el-icon>
                                    <span>{{ item.title }}</span>
                                </template>
                                <template v-for="subItem in item.children" :key="subItem.route">
                                    <el-menu-item :index="subItem.route">{{ subItem.title }}</el-menu-item>
                                </template>
                            </el-sub-menu>
                        </template>
                    </el-sub-menu>
                </template>
            </el-menu>
        </div>
    </div>
</template>
<style scoped>
.out {

    overflow: hidden;
    margin-right: 30px;
}
</style>