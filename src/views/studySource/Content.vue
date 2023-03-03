<script setup>
    import { menuData }  from './data.js'

    // components
    import Tabs from './Tabs.vue'

    const $props = defineProps({
            directionInfo:{
                type:Array
            }
        }
    )

    const $emits = defineEmits(['changeTab'])
    function handleChange(value){
        $emits('changeTab',value)
        
    }

</script>

<template>
    <div 
        v-for="item in $props.directionInfo" 
        :id="item.id"
        style="height:500px"
    > 
        <Tabs 
            :tabData="item.way" :title="item.type" :id="item.id+''"
            @changeTab="handleChange" 
        ></Tabs>
    </div>

</template>

<style>
    
</style>