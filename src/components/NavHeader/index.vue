<script setup>
import { onMounted, ref, getCurrentInstance } from 'vue'
import DogIcon from '../CustomIcon/DogIcon/index.vue';
import ProjectIcon from "../CustomIcon/ProjectIcon/index.vue"
import MemberIcon from "../CustomIcon/MemberIcon/index.vue"
import StudyIcon from "../CustomIcon/StudyIcon/index.vue"
import DailyIcon from "../CustomIcon/DailyIcon/index.vue"
import ContactIcon from "../CustomIcon/ContactIcon/index.vue"
import NavMenu from './NavMenu.vue';
const screenWidth = ref()
// const { ctx, proxy } = getCurrentInstance()
const isChangeNav = ref(false)
const isVernav = ref(false)
const popupNav = () => {
    isVernav.value = true
}
onMounted(() => {
    screenWidth.value = document.body.clientWidth;
    if (screenWidth.value <= 600) {
        isChangeNav.value = true
    } else {
        isChangeNav.value = false
    }
    window.onresize = () => {
        return (() => {
            screenWidth.value = document.body.clientWidth;
            // console.log(typeof screenWidth.value)
            if (screenWidth.value <= 600) {
                isChangeNav.value = true
            } else {
                isChangeNav.value = false
            }
        })();
    };
})
const MenuData = [
    {
        title: "首页",
        icon: DogIcon,
        route: "/home",
    },
    {
        title: "成果",
        icon: ProjectIcon,
        route: "/StudioAwards",
    },
    {
        title: "成员",
        icon: MemberIcon,
        route: "/member",
    },
    {
        title: "学习",
        icon: StudyIcon,
        route: "/4",
    },
    {
        title: "日常",
        icon: DailyIcon,
        route: "/daily",
    },
    {
        title: "联系我们",
        icon: ContactIcon,
        route: "/connect",
    }
]
</script>

<template>

    <template v-if="!isChangeNav">
        <div class="nav-header">
            <div class="nav-logo">
                <el-image style="width: 30px; height: 30px"
                    src="https://homyit-studio.github.io/Homyit-Guide/images/Homyit.png" fit="cover" />
                <p>宏奕工作室</p>
            </div>
            <NavMenu :MenuData="MenuData" Mode='horizontal'></NavMenu>
        </div>
    </template>
    <template v-else>

        <div class="nav-header mobile-nav">
            <div class="nav-logo">
                <el-image style="width: 30px; height: 30px"
                    src="https://homyit-studio.github.io/Homyit-Guide/images/Homyit.png" fit="cover" />
                <p>宏奕工作室</p>
            </div>
            <div class="get-nav">
                <el-icon :size="20" @click="popupNav">
                    <Expand v-if="isVernav" />
                    <Fold v-else />
                </el-icon>
            </div>
        </div>
        <el-drawer v-model="isVernav" :show-close="false" size="280px" direction="ltr">
            <NavMenu :MenuData="MenuData" Mode='vertical'></NavMenu>
        </el-drawer>
    </template>
</template>

<style lang="less">
.el-menu--horizontal{
    border-bottom:none;
}
.el-menu{
    border-right: none;
}
.read-the-docs {
    color: #888;
}
.nav-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    position: fixed;
    top: 0;
    z-index: 200;
    background-color: #fff;
    .nav-logo {
        display: flex;
        align-items: center;
        padding: 0 80px 0 30px;
        p {
            font-size: 16px;
            margin-left: 20px;
        }
    }
    .get-nav{
        margin-right: 100px;
    }
}
.mobile-nav {
    padding: 10px 0;
}
</style>