<script setup>
    import { ref, onMounted } from 'vue'
    import service from './data.js'
    // import { activeTabs } from './data.js'
    const $props = defineProps({
        tabData:{
            type:Array
        },
        title:{
            type: String
        },
        id:{
            type:String
        }
    })
    const $emits = defineEmits(['changeTab'])

    const cardInfo = ref([])
    const cardStyle = {
        padding: '0px',
        cursor:'pointer'
    }
    watch(()=>$props.id,(val,pre)=>{
        loadData()   
    })
    onMounted(()=>{
        $props.id && loadData()
    })
    async function loadData(){
        
        const params = {
            directionId : $props.id,
            wayId : service.activeTabs[$props.title]
        }
        
        const res = await service.httpCardInfo(params)
        
        cardInfo.value = res.data?.list
        // console.log(cardInfo.value);
        
    }

    // const activeTabs = ref($props.tabData[0].id)
    function handleClick(index){
        // console.log($props.id+'-'+index);
        let newvalue = $props.id+'-'+index 
        $emits('changeTab',newvalue)
        loadData()
    }

    function openSource(){

    }
    
</script>

<template>
    <div class="tab-header">{{$props.title}}</div>
    <!-- {{service.activeTabs}} -->
    <el-tabs v-model="service.activeTabs[$props.title]" class="demo-tabs" @tab-change="handleClick">
        <el-tab-pane 
            v-for="item in $props.tabData"
            :label="item.type"
            :name="item.id"
        >
            <el-row>
                <el-col :span="5" v-for="info in cardInfo">
                    <a :href="info.url" target="_Blank">
                        <el-card :body-style="cardStyle" @click="openSource">
                            <div class="tab-card-image">
                                <img
                                    :src="info.imgUrl"
                                />
                            </div>
                            <div class="tab-card-content">
                                {{info.message}}
                                <!-- <a src="www.bilibili.com">123</a> -->
                            </div>
                        </el-card>
                    </a>
                </el-col>
            </el-row>
        </el-tab-pane> 
    </el-tabs>
</template>

<style>
    
    .tab-header{
        font-size:1.3rem;
        /* text-align:left */
        margin:10px 0 10px 0;
    }
    .tab-card-image{
        width:100%;
        height:100px;
        /* height:80%; */
    }
    .tab-card-image img{
        width:100%;
        height:100%;
        object-fit:cover;
    }
    .tab-card-content{
        text-align:left;
        padding:2px;
    }
</style>