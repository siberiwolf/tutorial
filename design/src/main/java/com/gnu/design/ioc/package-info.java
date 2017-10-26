/**
 * 解释ioc的原理
 * 来源于https://www.zhihu.com/question/23277575中Sevenvidia的回答
 * normal包，不通过依赖倒置实现的系统，修改底层类，导致上层类都需要进行修改
 * dependency包，通过依赖注入实现依赖倒置的系统，修改底层类，上层类无需修改
 * @author siberiwolf@hotmail.com on 2017/10/26
 */
package com.gnu.design.ioc;