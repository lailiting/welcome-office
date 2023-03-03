<script setup>
    
    const textarea = ref('')
    const textareaSize = ref({ minRows:8 , maxRows: 12})
</script>

<template>
    <div style="margin-top:10vh">
        <el-input
            v-model="textarea"
            :autosize="textareaSize"
            type="textarea"
            placeholder="please Input"
        >
        </el-input>
        <el-button size="large" style="width:100%">发送</el-button>
    </div>
</template>

<style>
    
</style>