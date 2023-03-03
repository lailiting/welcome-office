
<template>
  <div class="wow fadeInDown">
    <el-image src="../../assets/daliy/南墙.png" style="width: 100%; height: 400px;"
      fit="cover"></el-image>
  </div>
  <template v-if="studioDaily.data.length == 0">
    <LoadingWait/>
  </template>
  <div class="daily-desci">
    <DailyItem :dailyData="studioDaily.data"></DailyItem>
  </div>
  <template v-if="studioDevice.data.length != 0">
    <!-- <StudioDevice :deviceData="studioDevice.data"></StudioDevice> -->
    <div class="device-list">
      <h1 class="device-title">工作室环境</h1>

      <StudioCondition/>
      <el-carousel :interval="2000" type="card" height="350px">
        <el-carousel-item v-for="item in studioDevice.data" :key="item">
          <p class="device-name"><svg t="1665820360555" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="16087" width="18" height="18"><path d="M144.34304 473.51808l467.78368 90.27584L641.65888 921.6 91.83232 780.45184z" fill="#D4A309" p-id="16088"></path><path d="M864.8704 430.85824l-252.74368 132.93568L641.65888 921.6l290.5088-210.08384z" fill="#D8D435" p-id="16089"></path><path d="M144.34304 473.51808l324.97664-111.59552 395.55072 68.93568-252.74368 132.93568z" fill="#FDDE2B" p-id="16090"></path><path d="M353.3824 308.224l216.65792 26.27584 14.76608 159.744-247.27552-41.02144z" fill="#D3A50A" p-id="16091"></path><path d="M691.48672 286.35136l-121.4464 48.14848s12.04224 160.29696 14.76608 159.744 139.50976-72.76544 139.50976-72.76544l-32.82944-135.12704z" fill="#D8D435" p-id="16092"></path><path d="M353.3824 308.224l142.80704-44.8512 195.29728 22.97856-121.4464 48.14848z" fill="#FDDE2B" p-id="16093"></path><path d="M217.66144 633.83552l46.51008 9.8304V686.08l-46.51008-10.67008zM408.45312 688.39424l46.51008 9.85088v42.3936l-46.51008-10.67008zM264.17152 740.63872l46.4896 9.85088v42.41408l-46.4896-10.67008zM495.18592 800.9728l54.76352 11.59168v49.95072l-54.76352-12.57472z" fill="#CA9305" p-id="16094"></path><path d="M691.48672 786.18624l2.74432 53.08416 46.51008-30.63808v-57.73312zM843.59168 712.33536v50.05312l36.6592-27.62752v-47.59552zM732.52864 673.4848v42.68032l32.27648-21.34016V652.6976zM795.99616 578.29376v42.68032l35.00032-23.53152v-41.5744z" fill="#D4BA25" p-id="16095"></path><path d="M468.80768 275.82464l-77.70112-169.59488L184.32 102.4z" fill="#67861E" p-id="16096"></path><path d="M184.32 102.4l88.02304 162.44736 196.46464 10.97728z" fill="#91CA6C" p-id="16097"></path><path d="M521.37984 296.69376l-9.95328-99.10272-61.5424-5.7344 41.12384 108.31872 0.18432 0.45056h30.57664z" fill="#80320B" p-id="16098"></path><path d="M532.35712 185.99936l-20.93056 11.59168 9.95328 99.10272 0.38912 3.93216h27.40224V176.66048z" fill="#B46465" p-id="16099"></path><path d="M549.1712 176.66048l-99.28704 15.19616 61.5424 5.7344 20.93056-11.59168zM532.35712 185.99936l-20.93056 11.59168z" fill="#AA581E" p-id="16100"></path></svg> {{item.title}}</p>
          <el-image style="width: 100%;height:350px" fit="cover" :src="item.imageList[0]" />
        </el-carousel-item>
      </el-carousel>
    </div>
  </template>
</template>
  
  
<script setup lang="ts">
import WOW from "../../utils/wow.js"
import { getData } from '../../utils/request';
import { onMounted, reactive, ref } from 'vue';
import DailyItem from "../../components/DailyItem/index.vue"
import LoadingWait from "../../components/LoadingWait/index.vue";
import StudioCondition from "../../components/StudioCondition/index.vue"
import { IDaily, IDailyList } from "./typeings"

// 是否在加载中
const loading = ref(false)

onMounted(() => {
  let wow = new WOW({
    boxClass: 'wow',//需要执行动画的元素的 class
    animateClass: 'animated', // animation.css 动画的 class
    offset: 50, // 元素的位置露出后距离底部多少像素执行
    mobile: true,
    live: true, // 异步加载的内容是否有效
    callback: function (box: any) {
      console.log("WOW: animating <" + box.tagName.toLowerCase() + ">")
    }
  })
  wow.init();
})


//获取上方图片

const topImageSrc = ref("")

const getTopImage = async () => {
  let res: any
  try {
    loading.value = true
    res = await getData("/api2/getImg", {
      type: "工作室日常",
      type_id: 10
    })
    if (res.code == 200) {
      topImageSrc.value = res.data[0].img_url
    }
    loading.value = false
  } catch (err) {

    loading.value = false
    console.log(err)
  }

}
getTopImage()


//获取工作室日常
const studioDaily: IDailyList = reactive({
  data: []
})

const getStudioDaily = async () => {
  let res: any
  try {
    res = await getData("/api1/introduce/view", {
      type: "工作室日常"
    })
    if (res.code == 200) {
      // console.log(res.data)
      studioDaily.data = res.data
    } else {
      console.log(res)
    }
  } catch (err) {
    console.log(err)
  }
}
getStudioDaily()


//获取工作室设备
const studioDevice: IDailyList = reactive({
  data: []
})

const getStudioDevice = async () => {
  let res: any
  try {
    res = await getData("/api1/introduce/view", {
      type: "设备"
    })
    if (res.code == 200) {
      studioDevice.data = res.data
    }
  } catch (err) {
    console.log(err)
  }
}
getStudioDevice()

</script>
  
<style lang="less">
.el-carousel {
  width: 80%;
  margin: 0 auto;
}

.daily-desci {
  position: relative;

  .daily-content-tag {
    top: -100px;
    right: 100px;
    position: absolute;
  }

}

.device-list {
  padding: 50px 0 80px 0;
  position: relative;

  .device-title {
    font-size: 30px;
    margin-bottom: 30px;
    color: transparent;
    text-shadow:

      0px 0px 0 #35d48a,

      1px -1px 0 #5dce99,

      2px -2px 0 #57c08f,

      3px -3px 0 #4fb183,

      4px -4px 0 #4aa47a,

      5px -5px 0 #4ba77c,

      6px -6px 0 #469d75,

      7px -7px 0 #469c74,

      8px -8px 0 #439870,

      9px -9px 0 #469c74,


      10px -10px 12px rgba(0, 0, 0, 0.55),

      10px -10px 1px rgba(0, 0, 0, 0.5);
    // text-shadow: 0px 0px 10px 1px #ff9a9e;
  }

  .el-carousel-item p {
    position: absolute;
    top: 30px;
    left: 100px;
    font-weight: bolder;
    font-size: 14px;

  }
}

</style>