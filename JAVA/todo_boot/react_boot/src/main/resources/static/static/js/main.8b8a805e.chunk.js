(this["webpackJsonptodo-list"]=this["webpackJsonptodo-list"]||[]).push([[0],{25:function(e,t,n){e.exports=n(57)},30:function(e,t,n){},31:function(e,t,n){},32:function(e,t,n){},56:function(e,t,n){},57:function(e,t,n){"use strict";n.r(t);var o=n(0),a=n.n(o),c=n(9),r=n.n(c),l=(n(30),n(2)),i=n(3),s=n(6),d=n(5),u=(n(31),function(e){var t=e.form,n=e.children;return a.a.createElement("main",{className:"todo-list-template"},a.a.createElement("div",{className:"title"},"\uc624\ub298 \ud560\uc77c (","\uc6b4\uc601\ubaa8\ub4dc",")"),a.a.createElement("section",{className:"form-wrapper"},t),a.a.createElement("section",{className:"todos-wrapper"},n))}),h=(n(32),n(4)),p=n(8),f=n.n(p),m="http://localhost:8083/todos",v=function(e){Object(s.a)(n,e);var t=Object(d.a)(n);function n(){var e;Object(l.a)(this,n);for(var o=arguments.length,a=new Array(o),c=0;c<o;c++)a[c]=arguments[c];return(e=t.call.apply(t,[this].concat(a))).state={todo:""},e.handleChange=function(t){e.setState({todo:t.target.value})},e.handleCreate=function(){var t=e.state.todo;e.props.addTodo({text:t,checked:!1}),e.setState({todo:""})},e.handleKeyPress=function(t){"Enter"===t.key&&e.handleCreate()},e}return Object(i.a)(n,[{key:"render",value:function(){var e=this.state.todo,t=this.handleChange,n=this.handleCreate,o=this.handleKeyPress;return a.a.createElement("div",{className:"form"},a.a.createElement("input",{value:e,onChange:t,onKeyPress:o}),a.a.createElement("div",{className:"create-button",onClick:n},"\ucd94\uac00"))}}]),n}(o.Component),O=Object(h.b)(null,{addTodo:function(e){return function(t){f.a.post(m,e).then((function(e){t({type:"ADD_TODOS",payload:e.data})})).catch((function(e){throw console.error(e),e}))}}})(v),y=(n(56),function(e){Object(s.a)(n,e);var t=Object(d.a)(n);function n(){var e;Object(l.a)(this,n);for(var o=arguments.length,a=new Array(o),c=0;c<o;c++)a[c]=arguments[c];return(e=t.call.apply(t,[this].concat(a))).handelRemove=function(t){e.props.removeTodo(t)},e.handleToggle=function(t){e.props.toggleTodo(t)},e}return Object(i.a)(n,[{key:"shouldComponentUpdate",value:function(e,t){return this.props.checked!==e.checked}},{key:"render",value:function(){var e=this,t=this.props,n=t.todoText,o=t.checked,c=t.id;return a.a.createElement("div",{className:"todo-item",onClick:function(){var t={id:c,text:n,checked:o};t.checked=!t.checked,e.handleToggle(t)}},a.a.createElement("div",{className:"remove",onClick:function(t){t.stopPropagation(),e.handelRemove(c)}},"\xd7"),a.a.createElement("div",{className:"todo-text ".concat(o&&"checked")},a.a.createElement("div",null,n)),o&&a.a.createElement("div",{className:"check-mark"},"\u2713"))}}]),n}(o.Component)),E=Object(h.b)(null,{removeTodo:function(e){return function(t){f.a.delete("".concat(m,"/").concat(e)).then((function(e){t({type:"REMOVE_TODOS",payload:e.data})})).catch((function(e){throw console.error(e),e}))}},toggleTodo:function(e){return function(t){f.a.put("".concat(m,"/").concat(e.id),e).then((function(e){t({type:"TOGGLE_TODOS",payload:e.data})})).catch((function(e){throw console.error(e),e}))}}})(y),b=function(e){Object(s.a)(n,e);var t=Object(d.a)(n);function n(){return Object(l.a)(this,n),t.apply(this,arguments)}return Object(i.a)(n,[{key:"componentDidMount",value:function(){this.props.fetchAllTodos()}},{key:"shouldComponentUpdate",value:function(e,t){return this.props.todos!==e.todos}},{key:"render",value:function(){var e=this.props.todos.map((function(e){var t=e.id,n=e.text,o=e.checked;return a.a.createElement(E,{id:t,todoText:n,checked:o,key:t})}));return a.a.createElement("div",null,e)}}]),n}(o.Component),k=Object(h.b)((function(e){return{todos:e.todos}}),{fetchAllTodos:function(){return function(e){f.a.get(m).then((function(t){e({type:"FETCH_TODOS",payload:t.data})})).catch((function(e){throw console.error(e),e}))}}})(b),T=function(e){Object(s.a)(n,e);var t=Object(d.a)(n);function n(){return Object(l.a)(this,n),t.apply(this,arguments)}return Object(i.a)(n,[{key:"render",value:function(){return a.a.createElement(u,{form:a.a.createElement(O,null)},a.a.createElement(k,null))}}]),n}(o.Component);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var g=n(7),j={todos:[{id:0,text:"",checked:!1}]},w=n(23),C=n(24),D=Object(g.createStore)((function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:j,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"FETCH_TODOS":case"ADD_TODOS":case"REMOVE_TODOS":case"TOGGLE_TODOS":return Object.assign({},e,{todos:t.payload});default:return e}}),Object(C.composeWithDevTools)(Object(g.applyMiddleware)(w.a)));r.a.render(a.a.createElement(a.a.StrictMode,null,a.a.createElement(h.a,{store:D},a.a.createElement(T,null))),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}},[[25,1,2]]]);
//# sourceMappingURL=main.8b8a805e.chunk.js.map