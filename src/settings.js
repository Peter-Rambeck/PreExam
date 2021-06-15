const USER_BASE =
  "https://peterrambeckandersen.com/tomcat/insession-starter/api/";

const INFO_BASE =
  "https://peterrambeckandersen.com/tomcat/insession-starter/api/";

const USER = {
  LOGIN: `${USER_BASE}/login`,
};

const INFO = {
  USER: `${INFO_BASE}/user`,
  ADMIN: `${INFO_BASE}/admin`,
  FETCH_MANY: `${INFO_BASE}/fetchMany`,
  FETCH_ONE: `${INFO_BASE}/fetchData`,
  BOOKS_ALL: `${INFO_BASE}/book/all`,
};

export { USER, INFO };
