import axios from "axios";

export function postData(strsql, params){
    return new Promise((resolve, reject) => {
            axios.post(strsql, params).then(res => {
                if(res.data.code == 200){
                    resolve(res.data)
                }else{
                    reject(res.data)
                }
            },err => {
                reject(err)
            })
    })
}

export function getData(strsql, params){
    console.log(params)
    return new Promise((resolve, reject) => {
            axios.get(strsql, {
                params : params
            }).then(res => {
                if(res.data.code == 200){
                    resolve(res.data)
                }else{
                    reject(res.data)
                }
            },err => {
                reject(err)
            })
    })
}
