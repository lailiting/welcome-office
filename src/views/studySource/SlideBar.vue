<script setup>
    import {menuData } from './data'
    import server from './data'

    const $props = defineProps({
        directionInfo:Array,
        active:{
            type:String
        }
    })

    const $emit = defineEmits(['changeView','mounted'])
    function handleSelect(index,indexPath,){
        $emit('changeView',index,indexPath)
        // console.log(index,indexPath)
    }
    let defaultActive = ref($props.directionInfo[0]?.id+'-')
    const active = ref('')
    watch(()=>$props.active, (val,pre)=>{
        active.value = val
    })
    watch(()=>$props.directionInfo,(val,pre)=>{
        active.value = val[0].id+'-'+val[0].way[0].id
    })
    onMounted(()=>{
        if($props.directionInfo.length > 0){
            active.value = $props.directionInfo[0].id+'-'+$props.directionInfo[0].way[0].id
        }
    })
    function click(){
        active.value = '1-5'
    }

</script>

<template>
    <!-- <el-button @click="click">click</el-button> -->
    <el-menu 
        ref="menuRef" 
        :default-active="active"
        unique-opened
        @select="handleSelect" 
    >
        <template v-for="(menuItem,index) in $props.directionInfo" :key="index">
            <el-sub-menu :index="menuItem.id+''" v-if="menuItem.way">
                <template #title>
                    <span>{{menuItem.type}}</span>
                </template>
                <template v-for="(childrenItemm,childrenIndex) in menuItem.way" :key="childrenIndex">
                    <el-menu-item :index="menuItem.id+'-'+childrenItemm.id+''">
                        <template #title>{{childrenItemm.type}}</template>
                    </el-menu-item>
                </template>
            </el-sub-menu>
            <el-menu-item :index="menuItem.id+''" v-else>
                <template #title>{{menuItem.title}}</template>
            </el-menu-item>
        </template>
    </el-menu>

    <!-- <el-menu 
        ref="menuRef" 
        :default-active="menuData[0].children[0].routeID"
        @select="handleSelect" 
    >
        <template v-for="(menuItem,index) in menuData" :key="index">
            <el-sub-menu :index="menuItem.routeID" v-if="menuItem.children">
                <template #title>
                    <span>{{menuItem.title}}</span>
                </template>
                <template v-for="(childrenItemm,childrenIndex) in menuItem.children" :key="childrenIndex">
                    <el-menu-item :index="childrenItemm.routeID">
                        <template #title>{{childrenItemm.title}}</template>
                    </el-menu-item>
                </template>
            </el-sub-menu>
            <el-menu-item :index="menuItem.routeID" v-else>
                <template #title>{{menuItem.title}}</template>
            </el-menu-item>
        </template>
    </el-menu> -->
</template>

<style>
    
</style>

