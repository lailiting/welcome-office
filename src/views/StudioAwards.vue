<script setup>
    import { View,Share } from '@element-plus/icons-vue'
    import { ref } from 'vue'
    import axios from 'axios'
    import { ElMessageBox } from 'element-plus'

    const dialogVisible = ref(false)
    const studioAward = reactive({
    data: []
    })

    const getStudioAward = async () => {
    let pageNo = 1
    let pageSize = 10
    let res
    try {
        res = await axios.get(`/api2/getPrize?pageNo=${pageNo}&pageSize=${pageSize}&id=`

)
        if (res.data.code == 200) {
        console.log(res.data)
        studioAward.data = res.data.data
        console.log(studioAward.data)
        } else {
        console.log(res.data)
        }
    } catch (err) {
        console.log(err)
    }
    }
    getStudioAward()

    const studioMessage = reactive({
    data: []
    })

    const getStudioMessage  = async () => {
    let res
    try {
        res = await axios.post("/api2/getProject",{
            pageNo:1,
            pageSize:10,
            type:" "
        })
        if (res.data.code == 200) {
        console.log(res.data)
        studioMessage.data = res.data.data
        console.log(studioMessage.data)
        } else {
        console.log(res.data)
        }
    } catch (err) {
        console.log(err)
    }
    }
    getStudioMessage()




    const studioProject = reactive({
    data: []
    })

    const getStudioProject = async () => {
    let res
    try {
        res = await axios.post("/api2/getProject",{
            pageNo:1,
            pageSize:10,
            type:'官网'
        })
        if (res.data.code == 200) {
        console.log(res.data)
        studioProject.data = res.data.data
        console.log(studioProject.data)
        } else {
        console.log(res.data)
        }
    } catch (err) {
        console.log(err)
    }
    }
    const studioProgram = reactive({
    data: []
    })

    const getStudioProgram = async () => {
    let res
    try {
        res = await axios.post("/api2/getProject",{
            pageNo:1,
            pageSize:10,
            type:'系统'
        })
        if (res.data.code == 200) {
        console.log(res.data)
        studioProgram.data = res.data.data
        console.log(studioProgram.data)
        } else {
        console.log(res.data)
        }
    } catch (err) {
        console.log(err)
    }
    }

</script>

<template>
    <div class="studio-awards">
        <div class="box-awards">
            <div class="section-header">
                <h3>AWARDS</h3>
            </div>
            <el-row :gutter="30">
                <el-col :span="14">
                    <div class="awardWrite" v-for="item in studioAward.data" :key="item.id">
                        <p>{{item.prize}}<br></p>
                    </div>
                </el-col>
                <el-col :span="8">
                    <div class="awardPicture">
                        <img src="../assets/award.png">
                    </div>
                </el-col>
            </el-row>
        </div>
        <div class="box-project">
            <div class="section-header">
                <h3>OUR  PROJECT</h3>
            </div>
            <div class="box-button">
                <div class="button">
                    <el-button type="primary" plain @click="getStudioMessage()">ALL</el-button>
                    <el-button type="primary" plain @click="getStudioProject()">官网</el-button>
                    <el-button type="primary" plain @click="getStudioProgram()">系统</el-button>
                </div>
            </div>
            <div class="big-box" v-for="item in studioProject.data" :key="item.id">
                <div class="box-web">
                    <img src="../assets/shengke.png" class="project-img">
                    <div class="box-icon">
                        <ul class="icon">
                            <li><el-icon :size="40" @click="dialogVisible = true" class="eye"><View /></el-icon></li>
                            <li><a href="#"><el-icon :size="40"><Share /></el-icon></a></li>
                        </ul>
                        <el-dialog
                            v-model="dialogVisible"
                            width="60%"
                        >
                            <img src="../assets/shengke.png" class="dialog-img">
                            <div>名称：</div>
                            <div>技术栈：</div>
                            <div></div>
                        </el-dialog>
                    </div>
                </div>
                <div class="project-info">
                    <h4>
                        <a href="https://yar.jxnu.edu.cn/">江西师范大学生命科学学院</a>
                    </h4>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>

/* *, ::after, ::before {
    box-sizing: border-box;
} */

.box-awards{
    margin-top: 6vh;
    padding: 1rem;
}
/* Award部分 */
h3{
    font-family: "Montserrat", sans-serif;
}
.section-header h3 {
    font-size: 36px;
    color: #111;
    text-transform: uppercase;
    text-align: center;
    font-weight: 700;
    position: relative;
    padding-bottom: 35px;
}
.section-header h3::before {
    content: '';
    position: absolute;
    display: block;
    width: 160px;
    height: 1px;
    background: #ddd;
    bottom: 1px;
    left: calc(50% - 80px);
}
.section-header h3::after {
    content: '';
    position: absolute;
    display: block;
    width: 50px;
    height: 3px;
    background: rgb(241,126,108);;
    bottom: 0;
    left: calc(50% - 30px);
}




.awardWrite{
    /* text-align: left; */
    /* margin-left: 16vw;
    margin-right: 10vw; */
    color: rgb(241,126,108);
}
p{
    font-size: 25px;
    padding:  2rem;
    line-height: 0.6rem;
    text-align: center;
}
.awardPicture img{
    max-width: 100%;
    max-height: 100%;
}



/* project部分 */
.button{
    text-align: center;
    padding-bottom: 35px;
}

.el-button--primary{
    width: 6vw;
    height: 6vh;
    background-color: rgb(238,238,238);
    border-color: rgb(238,238,238);
    color: #000;
}
.el-button--primary:hover{
    width: 6vw;
    height: 6vh;
    background-color: rgb(241,126,108);
    border-color: rgb(241,126,108);
}
.el-button--primary:focus{
    width: 6vw;
    height: 6vh;
    background-color: rgb(241,126,108);
    border-color: rgb(241,126,108);
    color: white;
}


/* 项目部分 */
#app{
    padding: 2rem;
}

.big-box{
    padding: 0;
    margin: 30px;
    height: 27vh;
    width: 28vw;
    position:relative;
    overflow:hidden;
    transition: 0.3s;
    box-shadow: 0px 2px 12px  rgb(0 0 0 / 8%);
}
.project-img{
    position:relative;
    height: 20vh;
}
.box-web:before,.box-web:after,.box-icon:before,.box-icon:after{
    content:'';
    background:rgba(0,0,0,0.5);
    height: 72%;
    width:25%;
    transform:translateY(-100%);
    position:absolute;
    left:0;
    top:0;
    z-index:1;
    transition:all 0.3s
}
.box-web:hover:before,.box-web:hover:after,
.box-web:hover .box-icon:before,
.box-web:hover .box-icon:after{
    transform:translateY(0)
}
.box-web:after{left:25%}
.box-web .box-icon:before{left:50%}
.box-web .box-icon:after{left:75%}
.box-web .icon{
    list-style:none;
    transform:translateX(-50%);
    position:absolute;
    left: 50%;
    top: 30%;
    z-index:2;
    transition:all 0.5s ease 0.3s
}
.box-web .icon li{
    float: left;
    opacity:0;
    transform:scale(0) rotate(360deg);
    transition:all 400ms
}
.box-web:hover .icon li{
    opacity:1;
    transform:scale(1) rotate(0)
}
.box-web .icon li a,
.box-web .icon li .eye
{
    color:var(--color_1);
    font-size:20px;
    line-height:40px;
    height:80px;
    width:80px;
    margin-bottom:10px;
    border-radius:50%;
    display:block;
    position:relative;
    transition:all 0.3s
}
.box-web .icon li a:hover{
    text-decoration:none;
    color:rgb(241,126,108);
    border-radius:0 20px 0 20px
}
.box-web .icon li .eye:hover{
    text-decoration:none;
    color:rgb(241,126,108);
    border-radius:0 20px 0 20px
}
.project-info{
    height: 35px;
}
.project-info h4 {
    /* padding: 4px; */
    margin: 0 auto;
    padding-bottom: 0.5rem;
    font-size: 18px;
    font-weight: 700;
}
.project-info h4 a{
    color: #333;
}
.project-info h4 a:hover{
    color: rgb(241,126,108);
}
.dialog-img{
    width: 80%;
    height: 40vh;
}

</style>
