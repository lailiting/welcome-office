<template>
  <div class="all-member">
    <div class="member-time">
      <FlipperVue />
      <template v-if="introduce.length == 0">
        <LoadingWait/>
      </template>
      <p>{{introduce}}</p>
    </div>
    <div class="direct-teacher">
      <el-card class="teacher-card">
        <template #header>
          <div class="card-header">
            <p>宏奕工作室指导老师</p>
          </div>
        </template>
        <div class="teacher-introduce">
          <p><span>姓名</span>罗文兵</p>
          <p><span>学历</span>硕士</p>
          <p><span>职务</span>计算机信息工程学院</p>
          <p><span>介绍</span>计算机信息工程学院</p>
        </div>
      </el-card>
      <el-card class="teacher-card">
        <template #header>
          <div class="card-header">
            <p>宏奕工作室指导老师</p>
          </div>
        </template>
        <div class="teacher-introduce">
          <p><span>姓名</span>李海燕</p>
          <p><span>学历</span>硕士</p>
          <p><span>职务</span>计算机信息工程学院</p>
          <p><span>介绍</span>计算机信息工程学院</p>
        </div>
      </el-card>
    </div>
    <div class="member-develop">
      <h1 class="member-title"><span class="title-image"></span>成员毕业发展</h1>
      <template v-if="loading">
        <LoadingWait/>
      </template>
     <template v-else>
      <div v-for="item in memberData.data" :key="item.grade">
        <StudioMemberItem :memberData="item"></StudioMemberItem>
      </div>
     </template>
    </div>
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue';
import { getData } from '../../utils/request';
import StudioMemberItem from '../../components/StudioMemberItem.vue';
import FlipperVue from '../../components/FilpClock//index.vue';
import LoadingWait from "../../components/LoadingWait/index.vue";
import { IAllMember, IMember, IMemberList } from './typeings';

const loading = ref(false)
//获取所有成员
const memberData: IAllMember = reactive({
  data: []
})

const getMemberData = async () => {
  let res: any
  try {
    loading.value = true
    res = await getData("/api1/member/list", {
      pageNo: 1,
      pageSize: 1000
    })
    if (res.code == 200) {
      console.log(res.data)

      let graderData: string[] = []
      let loadingGradeData: IMemberList[] = []

      res.data.list.map((item: any) => {
        let isin = graderData.some((grade: any) => {
          return grade == item.grade
        })
        if (!isin) {
          let obj: IMemberList = {
            grade: item.grade,
            memberList: [{
              name: item.name,
              workPlace: item.workPlace,
              workDirection: item.workDirection
            }]
          }
          loadingGradeData.push(obj)
          // console.log()
          graderData.push(item.grade)
        } else {
          loadingGradeData.map((data: any) => {
            let memberobj: IMember = {
              name: item.name,
              workPlace: item.workPlace,
              workDirection: item.workDirection
            }
            if (data.grade == item.grade) {
              data.memberList.push(memberobj)
            }
          })
        }
      })
      console.log(loadingGradeData)

      memberData.data = loadingGradeData
    } else {
      console.log(res)
    }
    loading.value = false
  } catch (err) {
    loading.value = false
    console.log(err)
  }
}

getMemberData()

//获取工作室介绍

let introduce = ref("")
const getIntroduce = async () => {
    try {
        let res = await getData("/api1/introduce/view", {
            type: "工作室介绍"
        })
        introduce.value = res.data.content
    } catch (err) {
        console.log(err)
    }
}

getIntroduce()


</script>

<style lang="less">
.all-member {
  padding-top: 50px;

  .direct-teacher {
    width: 90%;
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
    margin: 50px auto;

    .teacher-card {
      width: 500px;
      margin: 20px 0;
    }

    .card-header {
      text-align: left;
    }

    .teacher-introduce{
      p{
        padding: 18px 0;
        text-align: left;
        
  
      }

      span{
        display: inline-block;
        color: #6b7280;
        font-size: 14px;
        margin-right: 100px;
      }
    }
  }

  .member-time p {
    width: 80%;
    margin: 50px auto;
    text-align: justify;
  }

  .member-develop {
    width: 100%;
    overflow: hidden;
    padding-bottom: 50px;
  }
  

  .member-develop .member-title {
    position: relative;
    font-size: 30px;
    margin-bottom: 60px;
  }

  .member-develop .member-title .title-image {
    position: absolute;
    top: 4px;
    width: 30px;
    height: 25px;
    margin-left: -40px;
    background: url("../../assets/member/flower.png") center/cover;
  }
}
</style>