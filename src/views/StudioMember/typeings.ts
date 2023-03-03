export interface IMember{
    name:string,
    workDirection:string,
    workPlace:String
}

export interface IMemberList{
    grade : string,
    memberList: IMember[]
}

export interface IAllMember{
    data : IMemberList[]
}