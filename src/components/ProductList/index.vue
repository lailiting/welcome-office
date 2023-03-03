<template>
    <div class="product-list">
        <template v-for="(item) in productData.data" :key="item.id">
            <ProductItem :productIntro="item"></ProductItem>
        </template>
    </div>
</template>
<script lang='ts' setup>
import { reactive, toRefs, ref } from 'vue'
import { getData } from '../../utils/request';
import ProductItem from './ProductItem.vue';

let productData = reactive({
    data: []
})

const getProductData = async () => {
    try {
        let res = await getData("/api1/introduce/view", {
            type: "发展介绍"
        })
        if(res.code == 200){
            productData.data = res.data
        }
    }catch(err){
        console.log(err)
    }
}

getProductData()
</script>
<style lang = "less" scoped>
.product-list {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
    grid-gap: 10px;
    margin: 20px 0;
}
</style>
