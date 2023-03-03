<script setup>
    import StudioIntroduce from "../../components/StudioIntroduce/index.vue"
    import ProductList from "../../components/ProductList/index.vue"
    import DirectionIntroduce from "../../components/DirectionIntroduce.vue"
import DogIcon from "../../components/CustomIcon/DogIcon/index.vue"
    onMounted(() => {
        // console.log(route.path)    
    })
    const fits = ['fill', 'contain', 'cover', 'none', 'scale-down']
    const url = '/assets/home/video.mp4'
</script>

<template>
    <div class="video-contain">
        <video id="background_video" autoplay loop>
            <source src="/assets/home/video-text.mp4" type="video/mp4">
        </video>
        <div class="introduce">
            <StudioIntroduce></StudioIntroduce>
        </div>
        
        <div class="product-technique">
            <h2>团队技术</h2>
            <ProductList/>
        </div>
        <component :is="DogIcon"></component>
        <div class="section-header">
            <h2>方向介绍</h2>
            <DirectionIntroduce/>
        </div>
    </div>

</template>

<style>
    /* .video-contain{
        position:absolute;
        width:100vw;
        height:100vh;
        overflow:hidden;
        top:0;
        left:0;
        z-index:-1;
        text-align:left;
    } */
    video{ 
        /* position:fixed;
         */
         position: relative;
        width:100%;
        height:100vh;
        object-fit:cover;
        z-index:-1;
    }
    .homyitStdio{
        position:absolute;
        left:0;
        bottom:0;
        z-index:100;
    }

    .introduce{
        position: absolute;
        bottom: -70px;
        left: 80px;
    }
.section-header h2 {
    color: #111;
    text-transform: uppercase;
    text-align: center;
    font-weight: 700;
    position: relative;
    padding-bottom: 35px;
}
.section-header h2::before {
    content: '';
    position: absolute;
    display: block;
    width: 160px;
    height: 1px;
    background: #ddd;
    bottom: 1px;
    left: calc(50% - 80px);
}
.section-header h2::after {
    content: '';
    position: absolute;
    display: block;
    width: 50px;
    height: 3px;
    background: rgb(241,126,108);;
    bottom: 0;
    left: calc(50% - 30px);
}

</style>