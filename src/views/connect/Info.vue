<script setup>
    import server from './data.js'
    import { PhoneFilled,Promotion,HomeFilled } from '@element-plus/icons-vue'
    const homyit = ref({})
    onMounted(()=>{
        loadData()
    })
    async function loadData(){
        const res = await server.view()
        homyit.value = res.data 
    }
    const iconSize = ref(30)
</script>

<template>
    <!-- 邮箱 地址 电话 -->
    <el-row class="info-contain">
        <el-col :offset="2" :span="18">
            <el-icon :size="iconSize"><Promotion /></el-icon>
            <span class="info-title">邮箱:&nbsp;&nbsp;</span>
            <span class="info-content">{{homyit.email}}</span>
        </el-col>
        <el-col :offset="2" :span="18">
            <el-icon :size="iconSize"><PhoneFilled /></el-icon>
            <span class="info-title">电话:&nbsp;&nbsp;</span>
            <span class="info-content">{{homyit.phone}}</span>
        </el-col>
        <el-col :offset="2" :span="18">
            <el-icon :size="iconSize"><HomeFilled/></el-icon>
            <span class="info-title">地址:&nbsp;&nbsp;</span>
            <span class="info-content map-content">{{homyit.address}}</span>
        </el-col>
    </el-row>
</template>

<style>
    .info-contain{
        /* border:1px solid ; */
        height: 40vh;
    }
    .info-contain > div{
        /* border:1px solid red; */
        display:flex;
        align-items:center;
        justify-content:center;
    }
    .info-title{
        font-size:1.5rem;
        font-weight:1000;
    }
    .info-content{
        font-size:1.2rem;
        font-weight: 1000;
    }
    .map-content{
        text-decoration:underline;
        cursor:pointer;
    }
    .map-content:hover{
        color: #748ffc;
    }
    .border{
        border:1px solid blue;
    }
</style>