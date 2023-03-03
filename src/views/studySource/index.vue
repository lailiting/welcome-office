<script setup>
    import { onMounted } from 'vue'
    import Content from './Content.vue'
    import SlideBar from './SlideBar.vue'
    import server from './data.js' 
    onMounted(()=>{
        loadData()
    })
    
    const directionInfo = ref([])
    async function loadData(){
        const res = await server.httpDirectionInfo()
        directionInfo.value = res.data
        
    }

    function changeView(index,indexPath){
        const elementId = indexPath[0]
        const theDom = document.getElementById(elementId)
        // 获取页面Y轴的距离
        let currentY = document.documentElement.scrollTop || document.body.scrollTop
        currentY = Math.round(currentY)
        move(currentY,theDom.offsetTop)
        server.updateActiveTabById(indexPath[1]) 
    }

    function move(currentY,targetY){
        let distance  = targetY - currentY
        let step = 10
        let direction = distance > 0 ? 1:-1
        distance = Math.abs(distance)

        const time = setInterval(() => {
            if(distance > 0){
                currentY += step * direction
                scrollTo(0,currentY)
                distance -= step
            }else{
                clearTimeout(time)
            }
        }, 10) 
    }
    const active = ref('')
    function activeMenu(value){
        active.value = value
    }

</script>

<template>
    <el-row :gutter="20">
        <el-col :span="5">
            <!-- affix -->
            <el-affix :offset="100">
                <slideBar 
                    :directionInfo="directionInfo"
                    :active="active"
                    @changeView="changeView"
                />
            </el-affix>
        </el-col>
        <el-col :span="19">
            <content 
                :directionInfo="directionInfo" 
                @changeTab="activeMenu"
            />
        </el-col>
    </el-row>
</template>

<style>
    
</style>