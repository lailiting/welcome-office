<template>
    <div class="FlipClock">

        <div>
            <Flipper frontText="2" />
            <Flipper frontText="0" />
            <Flipper frontText="1" />
            <Flipper frontText="3" />
        </div>
        <div>
            <!-- <em>-</em> -->
            <em>-</em>
        </div>
        <div>
            <template v-for="(item, index) in filppers" :key="index">
                <Flipper ref="flipperMinute2" :frontText="item.front" :backText="item.back" />
            </template>
        </div>
    </div>
</template>
<script setup>
import Flipper from "./Flipper.vue"
import { reactive } from 'vue'
let filppers = reactive([
    {
        front: 2,
        back: 2
    },
    {
        front: 0,
        back: 0
    },
    {
        front: 1,
        back: 1
    },
    {
        front: 3,
        back: 3
    }
])
let date = new Date();
let endTimeStr = date.getFullYear()
let nextTimeStr = "2013"
let timeset = setInterval(function () {
    let nowTimeStr = nextTimeStr;
    nextTimeStr = (parseInt(nextTimeStr) + 1).toString();
    if (nextTimeStr == endTimeStr) {
        clearInterval(timeset)

    }
    for (let i = 0; i < 4; i++) {
        if (nowTimeStr[i] === nextTimeStr[i]) {
            continue;
        }

        filppers[i].front = nowTimeStr[i]
        filppers[i].back = nextTimeStr[i]
    }
}, 800);
</script>
<style lang = "less" scoped>
.FlipClock {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    text-align: center;

    .M-Flipper {
        margin: 0 3px;
    }

    em {
        display: inline-block;
        line-height: 102px;
        font-size: 66px;
        font-style: normal;
        vertical-align: top;
    }



}

@media screen and (max-width: 600px) {
    .FlipClock {
        em {
            width: 100vw;
            line-height: 40px;
        }
    }

}
</style>
