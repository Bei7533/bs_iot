(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6f88459c"],{"1f75":function(e,t,r){"use strict";var n=r("1da1"),a=(r("96cf"),r("d3b7"),r("6062"),r("3ca3"),r("ddb0"),r("caad"),r("2532"),r("99af"),r("25f0"),r("cee4")),o=r("2295"),c=r("5530"),u=(r("a9e3"),r("b680"),r("159b"),r("3ef4")),i=r("e466"),s=r("2ef0"),l=r.n(s),d=25,f=function(e){var t=1e3*Number((e.length/d).toFixed(3));return t<3e3?3e3:t>8e3?8e3:t},p=function(e){var t=!e||Object(s["isString"])(e)||Object(s["isFunction"])(e)?{message:e}:e;return t},b=function(e){var t=p(e),r=t.message,n=t.duration,a=t.showClose,o=t.type,i=n||r&&f(r)||void 0,s=a||"error"===o;return Object(u["a"])(Object(c["a"])(Object(c["a"])({},e),{},{duration:i,showClose:s}))};i["d"].forEach((function(e){b[e]=function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},r=p(t);return b(Object(c["a"])(Object(c["a"])({},r),{},{type:e}))}}));var m=b,O=r("323e"),v=r.n(O),g=(r("a5d8"),r("afbc")),j=r("0613"),h=r("2fc2"),w="BAD_TOKEN",N="TOKEN_TIME_OUT",x="BAD_USERNAME_OR_PWD",_=r("88c3");v.a.configure({showSpinner:!1,trickleSpeed:200});var y=new Set,k=function(){return y=new Set};Object.assign(a["a"].defaults,{baseURL:h["b"],timeout:2e4}),a["a"].interceptors.request.use((function(e){var t=j["a"].state.user;e.headers={Authorization:"Bearer "+t.token};var r=new AbortController;return e.signal=r.signal,e.controller=r,j["a"].commit("ADD_ABORT_CONTROLLER",r),e}),(function(e){Promise.reject(e)})),a["a"].interceptors.request.use(function(){var e=Object(n["a"])(regeneratorRuntime.mark((function e(t){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(t.doNotTriggerProgress){e.next=4;break}return j["a"].state.request_queue||v.a.start(),e.next=4,j["a"].dispatch("SET_REQ_CHANGE",!0);case 4:return e.abrupt("return",t);case 5:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}());var C=function(e,t){return 401===e&&[w,N].includes(t.code)},R=function(){var e=Object(n["a"])(regeneratorRuntime.mark((function e(t){var r;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,t.text();case 3:return r=e.sent,e.abrupt("return",JSON.parse(r));case 7:return e.prev=7,e.t0=e["catch"](0),e.abrupt("return",{});case 10:case"end":return e.stop()}}),e,null,[[0,7]])})));return function(t){return e.apply(this,arguments)}}();function E(){return S.apply(this,arguments)}function S(){return S=Object(n["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,j["a"].dispatch("SET_REQ_CHANGE",!1);case 2:t=j["a"].state.request_queue,t>0?v.a.inc():v.a.done();case 4:case"end":return e.stop()}}),e)}))),S.apply(this,arguments)}a["a"].interceptors.response.use((function(e){if(e.config.doNotTriggerProgress||E(),e.data instanceof Blob)return e;var t=e.config.controller;return j["a"].commit("REMOVE_ABORT_CONTROLLER",t),e.data||e.status}),function(){var e=Object(n["a"])(regeneratorRuntime.mark((function e(t){var r,n,a,c,u,i,s,d,f,p,b;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(t.config.doNotTriggerProgress||E(),!t.response){e.next=20;break}if(!(t.response.data instanceof Blob)){e.next=6;break}return e.next=5,R(t.response.data);case 5:t.response.data=e.sent;case 6:if(r=t.response,n=r.data,a=r.status,y.has(a)){e.next=18;break}if(y.add(a),u=401===a&&j["a"].state.afterCurrentUserPwdChanged,!C(a,n)){e.next=15;break}return u?j["a"].commit("SET_AFTER_CURRENT_USER_PWD_CHANGED",!1):o["a"].error(_["a"].global.t("Base.tokenExpiredMsg")),Object(g["c"])(),window.setTimeout(k,1e3),e.abrupt("return",Promise.reject(t));case 15:i=(null===(c=t.config)||void 0===c?void 0:c.errorsHandleCustom)&&Array.isArray(t.config.errorsHandleCustom)&&t.config.errorsHandleCustom.includes(a),i||((null===n||void 0===n?void 0:n.code)===x?o["a"].error(_["a"].global.t("Base.namePwdError")):null!==n&&void 0!==n&&n.code||null!==n&&void 0!==n&&n.message?m.error("".concat(a," ").concat(null!==(s=null===n||void 0===n?void 0:n.code)&&void 0!==s?s:"",": ").concat(null!==(d=null===n||void 0===n||null===(f=n.message)||void 0===f?void 0:f.toString())&&void 0!==d?d:"")):m.error(a+" Network error")),401===a&&Object(g["c"])();case 18:e.next=24;break;case 20:if(p=t.code===h["F"]&&t.config.handleTimeoutSelf,"ERR_CANCELED"!==t.code||"canceled"!==t.message){e.next=23;break}return e.abrupt("return");case 23:y.has(0)||(p||m.error(_["a"].global.t("Base.networkError")),y.add(0));case 24:return 0===j["a"].state.request_queue&&(y=new Set),l.a.throttle(k,2e3,{trailing:!1}),b=t.config.controller,j["a"].commit("REMOVE_ABORT_CONTROLLER",b),e.abrupt("return",Promise.reject(t));case 29:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}());t["a"]=a["a"]},"3d71":function(e,t,r){"use strict";r.d(t,"a",(function(){return s}));var n=r("1da1"),a=(r("96cf"),r("d81d"),r("ac1f"),r("1276"),r("d3b7"),r("caad"),r("7a23")),o=r("2ef0"),c=r.n(o),u=r("869a"),i=r("f727");function s(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{loadByDefault:!0,getVersion:!1},t=e.loadByDefault,r=e.hideProgress,o=e.timeout,s=e.getVersion,l=Object(a["ref"])([]),d=Object(a["ref"])(!1),f=Object(a["ref"])(!0),p=Object(a["reactive"])({latestVersion:"",isMutiVersion:!1}),b=function(e){var t=e.map((function(e){return e.version.split("-")[0]})),r=c.a.uniq(t);p.isMutiVersion=r.length>1,p.isMutiVersion?p.latestVersion=r.reduce((function(e,t){return Object(u["a"])(t,e)>0?t:e})):p.latestVersion=r[0],p.latestVersion="v".concat(p.latestVersion)},m=function(){var e=Object(n["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,d.value=!0,e.next=4,Object(i["l"])(r,o);case 4:if(e.t1=t=e.sent,e.t0=null!==e.t1,!e.t0){e.next=8;break}e.t0=void 0!==t;case 8:if(!e.t0){e.next=12;break}e.t2=t,e.next=13;break;case 12:e.t2=[];case 13:l.value=e.t2,f.value=l.value.some((function(e){return![0,"0"].includes(e.memory_total)})),s&&b(l.value),e.next=20;break;case 18:e.prev=18,e.t3=e["catch"](0);case 20:return e.prev=20,d.value=!1,e.finish(20);case 23:case"end":return e.stop()}}),e,null,[[0,18,20,23]])})));return function(){return e.apply(this,arguments)}}();return t&&m(),{nodes:l,lockTable:d,hasMemory:f,loadData:m,versionInfo:p}}},"452c":function(e,t,r){},"7a3a":function(e,t,r){"use strict";r.d(t,"a",(function(){return l}));var n=r("7a23"),a=r("9ee5");const o=Object(n["defineComponent"])({name:"RefreshRight"}),c={viewBox:"0 0 1024 1024",xmlns:"http://www.w3.org/2000/svg"},u=Object(n["createElementVNode"])("path",{fill:"currentColor",d:"M784.512 230.272v-50.56a32 32 0 1 1 64 0v149.056a32 32 0 0 1-32 32H667.52a32 32 0 1 1 0-64h92.992A320 320 0 1 0 524.8 833.152a320 320 0 0 0 320-320h64a384 384 0 0 1-384 384 384 384 0 0 1-384-384 384 384 0 0 1 643.712-282.88z"},null,-1),i=[u];function s(e,t,r,a,o,u){return Object(n["openBlock"])(),Object(n["createElementBlock"])("svg",c,i)}var l=Object(a["a"])(o,[["render",s]])},"869a":function(e,t,r){"use strict";r.d(t,"a",(function(){return n}));const n=(e,t)=>{const r=o(e),n=o(t),a=r.pop(),c=n.pop(),u=l(r,n);return 0!==u?u:a&&c?l(a.split("."),c.split(".")):a||c?a?-1:1:0},a=/^[v^~<>=]*?(\d+)(?:\.([x*]|\d+)(?:\.([x*]|\d+)(?:\.([x*]|\d+))?(?:-([\da-z\-]+(?:\.[\da-z\-]+)*))?(?:\+[\da-z\-]+(?:\.[\da-z\-]+)*)?)?)?$/i,o=e=>{if("string"!==typeof e)throw new TypeError("Invalid argument expected string");const t=e.match(a);if(!t)throw new Error(`Invalid argument not valid semver ('${e}' received)`);return t.shift(),t},c=e=>"*"===e||"x"===e||"X"===e,u=e=>{const t=parseInt(e,10);return isNaN(t)?e:t},i=(e,t)=>typeof e!==typeof t?[String(e),String(t)]:[e,t],s=(e,t)=>{if(c(e)||c(t))return 0;const[r,n]=i(u(e),u(t));return r>n?1:r<n?-1:0},l=(e,t)=>{for(let r=0;r<Math.max(e.length,t.length);r++){const n=s(e[r]||"0",t[r]||"0");if(0!==n)return n}return 0},d={">":[1],">=":[0,1],"=":[0],"<=":[-1,0],"<":[-1],"!=":[-1,1]};Object.keys(d)},9129:function(e,t,r){var n=r("23e7");n({target:"Number",stat:!0},{isNaN:function(e){return e!=e}})},"9d39":function(e,t,r){"use strict";r.d(t,"a",(function(){return a}));r("99af");var n=r("47e2");function a(e){var t=Object(n["b"])(),r=t.t,a=function(t,n){return n?r("".concat(e,".").concat(t),n):r("".concat(e,".").concat(t))};return{t:r,tl:a}}},"9ee5":function(e,t,r){"use strict";r.d(t,"a",(function(){return n}));var n=(e,t)=>{const r=e.__vccOpts||e;for(const[n,a]of t)r[n]=a;return r}},b06c:function(e,t,r){"use strict";var n,a=r("ade3"),o=(r("d81d"),r("fb6a"),r("d3b7"),r("9129"),r("a9e3"),r("c740"),r("99af"),r("498a"),r("ca5a")),c=r("9d39"),u=[o["I"].Millisecond,o["I"].Second,o["I"].Minute,o["I"].Hour,o["I"].Day],i=(n={},Object(a["a"])(n,o["I"].Millisecond,1e3),Object(a["a"])(n,o["I"].Second,60),Object(a["a"])(n,o["I"].Minute,60),Object(a["a"])(n,o["I"].Hour,24),n),s=function(e){return u.slice(e,-1).map((function(t,r){for(var n=i[u[e]],a=e+1;a<u.length-1-r;a++)n*=i[u[a]];return n}))};t["a"]=function(){var e,t=Object(c["a"])("General"),r=t.t,n=(e={},Object(a["a"])(e,o["I"].Millisecond,"General.ms"),Object(a["a"])(e,o["I"].Second,"General.sec"),Object(a["a"])(e,o["I"].Minute,"General.min"),Object(a["a"])(e,o["I"].Hour,"General.hour"),Object(a["a"])(e,o["I"].Day,"General.day"),e),i=function(e,t){if(void 0===t||!u.some((function(e){return e===t}))||Number.isNaN(Number(e))||0===Number(e))return e;for(var a=Number(e),o=u.findIndex((function(e){return e===t})),c=s(o),i=u.slice(o).reverse(),l="",d=a,f=0;f<c.length;f++){var p=Math.floor(d/c[f]);p>=1&&(l+=" ".concat(p," ").concat(r(n[i[f]],p)),d-=p*c[f])}return 0!==d&&(l+=" ".concat(d," ").concat(r(n[i[i.length-1]],d))),l.trim()},l=function(e){return i(Math.floor(e/1e3),o["I"].Second)},d=function(e){return i(e,o["I"].Second)};return{getDurationStr:i,transMsNumToSimpleStr:l,transSecondNumToSimpleStr:d}}},c027:function(e,t,r){"use strict";r.r(t);var n=r("5530"),a=(r("99af"),r("7a23")),o=r("4c61"),c=r("47e2"),u=r("7a3a"),i=r("b06c"),s=r("3d71"),l={class:"nodes app-wrapper"},d={class:"section-header"},f=Object(a["createElementVNode"])("div",null,null,-1),p=Object(a["defineComponent"])({name:"Nodes"}),b=Object(a["defineComponent"])(Object(n["a"])(Object(n["a"])({},p),{},{setup:function(e){var t=Object(c["b"])(),r=t.t,n=function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"Dashboard";return r(t+"."+e)},p=Object(i["a"])(),b=p.transMsNumToSimpleStr,m=Object(s["a"])(),O=m.nodes,v=m.lockTable,g=m.hasMemory,j=m.loadData;return function(e,t){var r=Object(a["resolveComponent"])("el-button"),c=Object(a["resolveComponent"])("router-link"),i=Object(a["resolveComponent"])("el-table-column"),s=Object(a["resolveComponent"])("el-progress"),p=Object(a["resolveComponent"])("el-tooltip"),m=Object(a["resolveComponent"])("el-table"),h=Object(a["resolveDirective"])("loading");return Object(a["openBlock"])(),Object(a["createElementBlock"])("div",l,[Object(a["createElementVNode"])("div",d,[f,Object(a["createVNode"])(r,{type:"primary",icon:Object(a["unref"])(u["a"]),onClick:Object(a["unref"])(j)},{default:Object(a["withCtx"])((function(){return[Object(a["createTextVNode"])(Object(a["toDisplayString"])(e.$t("Base.refresh")),1)]})),_:1},8,["icon","onClick"])]),Object(a["withDirectives"])((Object(a["openBlock"])(),Object(a["createBlock"])(m,{data:Object(a["unref"])(O),class:"nodes-table"},{default:Object(a["withCtx"])((function(){return[Object(a["createVNode"])(i,{prop:"node",label:n("name")},{default:Object(a["withCtx"])((function(e){var t=e.row;return[Object(a["createVNode"])(c,{class:"node-name",to:"nodes/".concat(t.node)},{default:Object(a["withCtx"])((function(){return[Object(a["createTextVNode"])(Object(a["toDisplayString"])(t.node),1)]})),_:2},1032,["to"])]})),_:1},8,["label"]),Object(a["createVNode"])(i,{label:n("nodeStatus"),width:"120"},{default:Object(a["withCtx"])((function(e){var t=e.row;return[Object(a["createElementVNode"])("span",{class:Object(a["normalizeClass"])([Object(a["unref"])(o["d"])(t.node_status,"running")?"running-status":"stop-status"])},Object(a["toDisplayString"])(Object(a["unref"])(o["d"])(t.node_status,"running")?n("running"):n("stopped")),3)]})),_:1},8,["label"]),Object(a["createVNode"])(i,{prop:"uptime",label:n("uptime")},{default:Object(a["withCtx"])((function(e){var t=e.row;return[Object(a["createTextVNode"])(Object(a["toDisplayString"])(Object(a["unref"])(b)(t.uptime)),1)]})),_:1},8,["label"]),Object(a["createVNode"])(i,{prop:"version",label:n("version"),width:"90"},null,8,["label"]),Object(a["createVNode"])(i,{label:"Erlang ".concat(n("process"))},{default:Object(a["withCtx"])((function(e){var t=e.row;return[Object(a["createVNode"])(p,{placement:"top",effect:"dark",content:"".concat(t.process_used,"/").concat(t.process_available)},{default:Object(a["withCtx"])((function(){return[Object(a["createVNode"])(s,{"stroke-width":20,percentage:Object(a["unref"])(o["c"])(t.process_used,t.process_available),format:function(){return t.process_used}},null,8,["percentage","format"])]})),_:2},1032,["content"])]})),_:1},8,["label"]),Object(a["unref"])(g)?(Object(a["openBlock"])(),Object(a["createBlock"])(i,{key:0,label:n("memory"),prop:"memory_used"},{default:Object(a["withCtx"])((function(e){var t=e.row;return[Object(a["createVNode"])(p,{placement:"top",effect:"dark",content:"".concat(t.memory_used,"/").concat(t.memory_total)},{default:Object(a["withCtx"])((function(){return[Object(a["createVNode"])(s,{"stroke-width":20,percentage:Object(a["unref"])(o["c"])(t.memory_used,t.memory_total),format:function(){return t.memory_used}},null,8,["percentage","format"])]})),_:2},1032,["content"])]})),_:1},8,["label"])):Object(a["createCommentVNode"])("",!0),Object(a["createVNode"])(i,{label:n("osCpuLoad")},{default:Object(a["withCtx"])((function(e){var t=e.row;return[Object(a["createVNode"])(p,{class:"box-item",effect:"dark",content:"load1/load5/load15",placement:"top"},{default:Object(a["withCtx"])((function(){return[Object(a["createTextVNode"])(Object(a["toDisplayString"])(t.load1)+"/"+Object(a["toDisplayString"])(t.load5)+"/"+Object(a["toDisplayString"])(t.load15),1)]})),_:2},1024)]})),_:1},8,["label"])]})),_:1},8,["data"])),[[h,Object(a["unref"])(v),void 0,{lock:!0}]])])}}}));r("f1ee");const m=b;t["default"]=m},f1ee:function(e,t,r){"use strict";r("452c")},f727:function(e,t,r){"use strict";r.d(t,"n",(function(){return c})),r.d(t,"i",(function(){return u})),r.d(t,"h",(function(){return i})),r.d(t,"g",(function(){return s})),r.d(t,"c",(function(){return l})),r.d(t,"p",(function(){return d})),r.d(t,"b",(function(){return f})),r.d(t,"o",(function(){return p})),r.d(t,"l",(function(){return b})),r.d(t,"j",(function(){return O})),r.d(t,"m",(function(){return g})),r.d(t,"k",(function(){return h})),r.d(t,"f",(function(){return w})),r.d(t,"a",(function(){return x})),r.d(t,"e",(function(){return y})),r.d(t,"d",(function(){return k}));var n=r("5530"),a=r("1da1"),o=(r("96cf"),r("1f75"));function c(e){return o["a"].post("/login",e)}function u(e){return o["a"].get("/metrics",{params:{aggregate:e}})}function i(){return o["a"].get("/monitor_current",{doNotTriggerProgress:!0})}function s(e){return o["a"].get("/monitor",{params:{latest:e}})}function l(){return o["a"].get("/prometheus")}function d(e){return o["a"].put("/prometheus",e)}function f(){return o["a"].get("/opentelemetry")}function p(e){return o["a"].put("/opentelemetry",e)}function b(){return m.apply(this,arguments)}function m(){return m=Object(a["a"])(regeneratorRuntime.mark((function e(){var t,r,n=arguments;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t=n.length>0&&void 0!==n[0]&&n[0],r=n.length>1&&void 0!==n[1]?n[1]:2e4,e.abrupt("return",o["a"].get("/nodes",{doNotTriggerProgress:t,timeout:r}));case 3:case"end":return e.stop()}}),e)}))),m.apply(this,arguments)}function O(e){return v.apply(this,arguments)}function v(){return v=Object(a["a"])(regeneratorRuntime.mark((function e(t){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",o["a"].get("/nodes/".concat(encodeURIComponent(t))));case 1:case"end":return e.stop()}}),e)}))),v.apply(this,arguments)}function g(){return j.apply(this,arguments)}function j(){return j=Object(a["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",o["a"].get("/stats",{doNotTriggerProgress:!0}));case 1:case"end":return e.stop()}}),e)}))),j.apply(this,arguments)}function h(e){return o["a"].get("/nodes/".concat(encodeURIComponent(e),"/stats"))}function w(){return N.apply(this,arguments)}function N(){return N=Object(a["a"])(regeneratorRuntime.mark((function e(){var t,r,a=arguments;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]&&a[0],r=a.length>1&&void 0!==a[1]?a[1]:{},e.abrupt("return",o["a"].get("/alarms",{params:Object(n["a"])({activated:String(!t)},r)}));case 3:case"end":return e.stop()}}),e)}))),N.apply(this,arguments)}function x(){return _.apply(this,arguments)}function _(){return _=Object(a["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",o["a"].delete("/alarms"));case 1:case"end":return e.stop()}}),e)}))),_.apply(this,arguments)}var y=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};return e.topic=e.topic||void 0,o["a"].get("/topics",{params:e})};function k(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};return o["a"].get("/subscriptions",{params:e})}}}]);