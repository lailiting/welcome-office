<script setup>
    import Info from './Info.vue'
    import Map from './Map.vue'
    import LeaveMessage from './LeaveMessage.vue'
</script>

<template>
    <el-row class="info-main">
        <el-col :span="8">
            <Info/>
        </el-col>
        <el-col :span="10" :offset="1" style="height:50%">
            <Map/>
        </el-col>
        <el-col :span="20" :offset="3">
            <!-- <LeaveMessage/> -->
        </el-col>
    </el-row>
</template>

<style>
    .info-main{
        display:flex;
        justify-content:center;
        align-items:center;
        height:60vh;
        /* border:1px solid red; */
        margin-top: 10vh;
    } 
</style>