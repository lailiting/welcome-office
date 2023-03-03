<script setup>
defineProps({
    memberData: Object
})

</script>
<template>
    <li>
    <li class="member-item">
        <div class="time-left member-content">
        </div>
        <div class="time-line"></div>
        <div class="time-right member-content">
            <h1>{{memberData.grade}}</h1>
        </div>
    </li>
    <ul>
        <template v-for="(member, index) in memberData.memberList" :key="member.name">
            <li class="member-item" v-if="index %2 != 0">
                <div class="time-left member-content ">
                </div>
                <div class="time-line"></div>
                <div class="time-right member-content animate__animated">
                    <p class="name">{{member.name}}</p>
                    <p class="direction"><el-icon color="#3eaf7c"><HomeFilled /></el-icon><span v-show="member.workPlace.length != 0">{{member.workPlace}}</span><span>{{member.workDirection}}</span></p>
                </div>
            </li>
            <li class="member-item" v-else>
                <div class="time-left member-content animate__animated">
                    <p  class="name">{{member.name}}</p>
                    <p class="direction"><el-icon color="#3eaf7c"><HomeFilled /></el-icon><span v-show="member.workPlace.length != 0">{{member.workPlace}}</span><span>{{member.workDirection}}</span></p>
                </div>
                
                <div class="time-line"></div>
                <div class="time-right member-content">
                </div>
            </li>
        </template>
    </ul>
    </li>
</template>

<style lang="less">
.member-item {
    display: flex;
    justify-content: center;
    box-sizing: border-box;
    position: relative;

    .name{
        margin: 0 10px;
    }
}

h1,
p {
    margin: 0;
    padding: 0;
}
.direction{
    margin-top: 10px;
}

.direction span{
    display: inline-block;
    padding: 0 10px;
}

.time-left .direction{
    display: flex;
    align-items: center;
    justify-content: flex-end;
}

.time-right .direction{
    display: flex;
    align-items: center;
    justify-content: flex-start;
}

.member-item:hover .time-line::after {
    background-color: #3eaf7c;

}

.member-item:hover .member-content {
    color: #3eaf7c;
    animation: bounce;
    animation-duration: 1s;
}

.time-line::after {
    content: "";
    position: absolute;
    left: -3.5px;
    z-index: 100;
    width: 10px;
    height: 10px;
    background-color: #fff;
    border-radius: 50%;
    box-shadow: 0px 0px 1px 1px #d8d8d8;
}

.member-item .time-left,
.member-item .time-right {
    color: #7f7f7f;
    font-size: 16px;
    box-sizing: border-box;
    width: 45%;
    padding-bottom: 20px;
    margin-top: 10px;
}

.member-item .time-left {
    text-align: right;
    padding-right: 20px;
}

.member-item .time-right {
    text-align: left;
    padding-left: 20px;
}

.time-right h1 {
    font-size: 26px;
    color: #242424;
}

.time-line {
    position: relative;
    width: 4px;
    background-color: rgb(231, 231, 231);
    /* height: 100%; */
}
</style>