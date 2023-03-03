<template>
  <div class="product-box">
    <div class="front-face">
        <div><el-image style="width: 50px; height: 50px" :src="productIntro.imageList[0]"></el-image></div>
        <p>{{productIntro.title}}</p>
    </div>
    <div class="back-face">
        <span>{{productIntro.title}}</span>
        <p>{{productIntro.content}}</p>
    </div>
  </div>
</template>
<script lang='ts' setup>
// import { reactive, toRefs, ref} from 'vue'
import type { PropType } from "vue"

interface IProductIntro{
    type:string,
    id:number,
    title:string,
    content:string,
    imageList:string[]
}
const props = defineProps({
    productIntro : {
        type : Object as PropType<IProductIntro>,
        required: true
    }
})
</script>
<style lang = "less" scoped>
    .product-box{
        position: relative;
        width: 320px;
        margin: 10px auto;
        perspective: 1000px;
        
        .front-face{
            background: #fff;
            height: 200px;
            width: 100%;
            padding: 12px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            box-shadow: 0px 5px 20px 0px rgb(221, 221, 221);
            transition: all 0.5s ease;

            p{
                background: linear-gradient(-135deg, #c850c0,#4158d0);
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                font-size: 22px;
                font-weight: 600;
            }
        }
        


        .back-face{
            // box-sizing: border-box;
            position: absolute;
            top: 0;
            left: 0;
            z-index: 100;
            height: 200px;
            width: 100%;
            padding: 12px;
            // display: none;
            color: #fff;
            background: linear-gradient(-135deg, #c850c0,#4158d0);
            backface-visibility: hidden;
            opacity: 0;
            transform: translateY(110px) rotateX(-90deg);
            transition: all 0.5s ease;
            transform-style: preserve-3d;


            p{
                margin-top: 10px;
                text-align: justify;
            }
        }
    }

    .product-box:hover .back-face{
        opacity: 1;
        transform: rotateX(0deg);
    }
    .product-box:hover .front-face{
        opacity: 0;
        transform: translateY(-110px) rotateX(90deg);
    }
</style>
