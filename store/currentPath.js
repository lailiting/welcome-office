import {defineStore} from "pinia"

export const useStore = defineStore({
    id : "historyPath",
    state : () =>({
        path : "/home"
    }),
    action : {
        setCurrentPath(path){
            this.path = path
        }
    }
})