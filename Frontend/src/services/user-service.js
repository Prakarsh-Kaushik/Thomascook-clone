import { myAxios } from "./helper";
import { privateAxios } from "./helper";
export const signUp = (user) => {
  return myAxios.post("/user/register", user).then((response) => response.data);
};

export const loginUser = (loginDetail) => {
  return myAxios
    .post("/user/login", loginDetail)
    .then((response) => response.data);
};

// export const getUser = (userId) => {
//   return myAxios.get(`/users/${userId}`).then((resp) => resp.data);
// };
// export const getLocation = ()=>{
//     return privateAxios.get("/location/fetch").then((response)=>response.data)
// }