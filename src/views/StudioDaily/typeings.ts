export interface IDaily {
    id : number;
    content?:string;
    imageList: string[],
    title:string,
    type:string
}

export interface IDailyList {
    data : IDaily[]
}