<script setup>
defineProps({
  devData: Object,
  index: Number
})
// let isji = index + 1 % 2 == 0 ? false : true;
</script>

<template>
  <div class="develop-item">
    <template v-if="(index + 1) % 2 != 0 ">
      <div class="dev-intro-item">
        <div class="dev-bgl-image"></div>
        <div class="dev-descri">
          <h2>
            <el-icon :size="30" color="#dbe8c7">
              <LocationFilled />
            </el-icon> {{devData.title}}
          </h2>
          <p>
            {{devData.content}}
          </p>
        </div>
      </div>
      <div class="dev-lto">
        <span class="small-fly"></span>
      </div>
    </template>
    <template v-else>
      <div class="dev-intro-item item-reverse">
         <div class="dev-descri">
          <h2>
            <el-icon :size="30" color="#dbe8c7">
              <LocationFilled />
            </el-icon> {{devData.title}}
          </h2>
          <p>
            {{devData.content}}
          </p>
        </div>
        <div class="dev-bgr-image"></div>
      </div>
      <div class="dev-rto">
        <span class="small-fly"></span>
      </div>
    </template>
  </div>
</template>

<style scoped>
.dev-intro-item {
  width: 80%;
  display: flex;
  justify-content: center;
  ;
  align-items: center;
  margin: 0 auto;
}

.dev-bgl-image {
  width: 300px;
  height: 300px;
  margin-right: 100px;
  background: url("../../assets/wrokintroibg.png") center/cover;
}
.dev-bgr-image {
  width: 300px;
  height: 300px;
  margin-left: 100px;
  background: url("../../assets/wrokintroibg.png") center/cover;
}

.dev-descri {
  text-align: left;
  width: 50%;
}

 .dev-lto .small-fly {
  display: inline-block;
  width: 50px;
  height: 50px;
  background: url("../../assets/flyto.png") center/cover;
}
.dev-rto .small-fly {
  display: inline-block;
  width: 90px;
  height: 50px;
  background: url("../../assets/chezi.png") center/cover;
}

@media screen and (max-width: 800px) {
  .dev-intro-item{
    flex-direction: column;
  }
  .dev-bgl-image,.dev-bgr-image{
    margin: 0;
  }
  .dev-descri{
    width: 80%;
  }
  .item-reverse{
    flex-direction: column-reverse;
  }
}
</style>