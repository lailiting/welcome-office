<template>
  <div class="studio-condition">
    <div class="card">
       <div class="image-list">
        <div class="image-box">
            <el-image style="width: 100%" src="../../assets/daliy/工作室环境1.jpg" mode="cover"></el-image>
        </div>
        <div class="image-box">
            <el-image style="width: 100%" src="../../assets/daliy/工作室环境2.jpg"  mode="cover"></el-image>
        </div>
       </div>
        <div class="content">
            <p> 工作室在专业上，主要有开办技术培训、参加专业竞赛、开发团队产品等业务。小伙伴们内一起在环境好，氛围好的工作室一起参加比赛，对接项目，休闲之余，可以用投影仪观赏电影一起畅聊天地，在考试周也不用担心找不到
                自习教室哦，可以在工作室和小伙伴们一起备战期末。
                工作室内还有空调、冰箱、免费WiFi、打印机、丰富的书架等，让你在一年四季都能沉浸式学习！</p>
        </div>
    </div>
  </div>
</template>
<script lang='ts' setup>
import { reactive, toRefs, ref} from 'vue'
    
</script>
<style lang = "less" scoped>
    .studio-condition{
        position: relative;
        width: 90%;
        min-height: 560px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-wrap: wrap;
        padding: 30px;

        .card{
            position: relative;
            width: 100%;
            height: 255px;
            background-color: #fff;
            margin: 30px 10px;
            padding: 20px 15px;
            box-shadow: 0px 5px 202px rgb(229, 229, 229);
            transition: 0.3s ease-in-out;
        }

        .card:hover{
            height: 420px;
        }

        .image-list{
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .image-box{
            position: relative;
            width: 40%;
            height: 260px;
            top: -60px;
            left: 20px;
            z-index: 1;
            box-shadow: 0 5px 20px rgb(185, 183, 183);
        }

        .content{
            position: relative;
            margin-top: -140px;
            padding: 10px 185px;
            text-align: justify;
            color: #111;
            visibility: hidden;
            opacity: 0;
            transition: 0.3s ease-in-out;
        }
        .card:hover .content{
            visibility: visible;
            opacity: 1;
            margin-top: 20px;
            transition-delay: 0.3s;
        }
    }

    @media screen and(max-width: 800px){
        .content{
            font-size: 12px;
            margin-top: -20px !important;
            padding: 10px 10px !important;
        }
    }
</style>
