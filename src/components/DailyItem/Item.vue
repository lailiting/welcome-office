<script setup>
import SliderImage from '../SliderImage/index.vue';
defineProps({
  dailyData: Object,
  index: Number
})
// let isji = index + 1 % 2 == 0 ? false : true;
</script>

<template>
  <div class="daily-item-page">
    <template v-if="(index + 1) % 2 != 0 ">
      <div class="daily-item">
        <SliderImage :imageData="dailyData.imageList"></SliderImage>
        <div class="dev-descri">
          <h2>
            <svg t="1665820304456" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="15908" width="25" height="25"><path d="M302.91968 640.79872l224.33792 44.25728 12.20608 236.544-264.00768-70.20544z" fill="#557800" p-id="15909"></path><path d="M653.9264 616.38656l-126.6688 68.66944 12.20608 236.544 148.02944-105.30816z" fill="#79B634" p-id="15910"></path><path d="M302.91968 640.79872l158.72-56.46336 192.28672 32.0512-126.6688 68.66944z" fill="#BEE942" p-id="15911"></path><path d="M245.88288 386.68288l203.01824 40.05888 11.03872 214.05696-238.91968-63.52896z" fill="#7B9F01" p-id="15912"></path><path d="M563.52768 364.58496l-114.62656 62.1568 11.03872 214.05696 133.95968-95.29344z" fill="#86D85A" p-id="15913"></path><path d="M245.88288 386.68288l143.62624-51.0976 174.01856 28.99968-114.62656 62.1568z" fill="#BEE942" p-id="15914"></path><path d="M469.27872 450.53952l224.31744 44.25728 12.22656 236.544-264.02816-70.18496z" fill="#7B9F01" p-id="15915"></path><path d="M820.26496 426.12736l-126.6688 68.66944 12.22656 236.544 148.02944-105.28768z" fill="#86D85A" p-id="15916"></path><path d="M639.30368 102.4l-128.18432 209.44896-93.5936-15.13472-44.76928-77.312 80.36352-48.8448 52.89984 16.2816 17.3056-60.02688z" fill="#558B19" p-id="15917"></path><path d="M639.30368 102.4l31.0272 107.84768-42.72128 41.71776 53.92384 34.07872 12.20608 90.03008-73.25696 13.74208-109.3632-77.96736z" fill="#77C653" p-id="15918"></path><path d="M469.27872 450.53952l158.69952-56.46336 192.28672 32.0512-126.6688 68.66944z" fill="#BEE942" p-id="15919"></path><path d="M197.632 523.28448l224.33792 44.25728 12.20608 236.544-264.02816-70.18496z" fill="#7B9F01" p-id="15920"></path><path d="M452.44416 352.68608l-69.26336 35.79904 66.88768 1.3312z" fill="#694803" p-id="15921"></path><path d="M548.61824 498.87232l-126.64832 68.66944 12.20608 236.544 148.02944-105.28768z" fill="#86D85A" p-id="15922"></path><path d="M197.632 523.28448l158.69952-56.46336 192.28672 32.0512-126.64832 68.66944z" fill="#BEE942" p-id="15923"></path><path d="M533.23776 287.31392l-96.54272 24.6784h44.66688z" fill="#737206" p-id="15924"></path><path d="M452.44416 352.68608l-93.67552 143.95392 44.25728 8.64256 88.33024-167.48544z" fill="#6E5300" p-id="15925"></path><path d="M434.56512 487.99744l-31.5392 17.28512 88.33024-167.48544 5.75488 14.88896z" fill="#828A01" p-id="15926"></path><path d="M497.11104 352.68608h-44.66688l-15.74912-40.69376h44.66688z" fill="#694C00" p-id="15927"></path><path d="M501.69856 341.99552l124.12928 108.35968 49.84832 6.61504-173.9776-134.30784z" fill="#6E5300" p-id="15928"></path><path d="M699.0848 446.79168l-23.40864 10.17856-173.9776-134.30784 27.97568-2.6624z" fill="#828A01" p-id="15929"></path><path d="M533.23776 287.31392l-51.87584 24.6784 15.74912 40.69376 54.0672-23.01952z" fill="#7E8503" p-id="15930"></path></svg> {{ dailyData.title}}
          </h2>
          <p>
            {{dailyData.content}}
          </p>
        </div>
      </div>
    </template>
    <template v-else>
      <div class="daily-item item-reverse">
         <div class="dev-descri">
          <h2>
            <svg t="1665820266387" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="15738" width="25" height="25"><path d="M321.6384 304.88576l215.4496-43.45856L777.216 763.24864l-298.47552-30.33088z" fill="#CE9A06" p-id="15739"></path><path d="M632.46336 167.936l-95.37536 93.4912L777.216 763.24864l60.14976-210.24768z" fill="#D9D335" p-id="15740"></path><path d="M321.6384 304.88576l215.4496-43.45856L632.46336 167.936l-144.65024 72.13056z" fill="#EFCF1C" p-id="15741"></path><path d="M186.63424 334.35648l217.23136 33.42336L456.3968 921.6 186.63424 790.30272z" fill="#CE9A06" p-id="15742"></path><path d="M525.6192 312.87296l-121.7536 54.90688L456.3968 921.6l128.90112-176.66048z" fill="#D9D335" p-id="15743"></path><path d="M186.63424 334.35648l217.23136 33.42336 121.7536-54.90688-169.49248-28.65152z" fill="#EFCF1C" p-id="15744"></path><path d="M276.91008 200.27392l192.24576-95.47776L514.51904 102.4l-181.3504 97.87392z" fill="#7C870D" p-id="15745"></path><path d="M370.8928 238.08v87.92064h-18.69824l-41.7792-87.92064z" fill="#6F7D02" p-id="15746"></path><path d="M403.90656 216.9856c0.2048 0.59392-7.168 96.68608-7.168 96.68608s-25.86624 11.53024-25.86624 10.752v-86.34368l33.03424-21.0944z" fill="#86AD06" p-id="15747"></path><path d="M453.8368 171.43808c1.00352 1.18784 45.3632 86.7328 45.3632 86.7328l-18.10432 9.35936-78.97088-64.06144 51.712-32.03072z" fill="#6F7D02" p-id="15748"></path><path d="M516.7104 247.62368l-17.5104 10.5472-45.3632-86.7328 47.94368-47.94368z" fill="#86AD06" p-id="15749"></path><path d="M362.92608 252.78464h-56.25856l-29.75744-52.51072h56.25856z" fill="#5F7000" p-id="15750"></path><path d="M333.16864 200.27392L514.51904 102.4l16.30208 58.08128-167.89504 92.30336z" fill="#7B9F0B" p-id="15751"></path></svg> {{dailyData.title}}
          </h2>
          <p>
            {{dailyData.content}}
          </p>
        </div>
        <SliderImage :imageData="dailyData.imageList"></SliderImage>
      </div>
    </template>
  </div>
</template>

<style scoped lang="less">
.daily-item{
  width: 80%;
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  margin: 60px auto;
}


.dev-descri {
  text-align: left;
  width: 45%;
  padding: 20px;
  h2{
    display: flex;
    align-items: center;
    justify-content: center;
    .icon{
      margin-right: 10px;
    }
  }
  p{
    color: #999;
  }
}

@media screen and (max-width: 800px) {
  .daily-item{
    flex-direction: column;
  }
  .dev-descri{
    width: 80%;
  }
  .item-reverse{
    flex-direction: column-reverse;
  }
}
</style>