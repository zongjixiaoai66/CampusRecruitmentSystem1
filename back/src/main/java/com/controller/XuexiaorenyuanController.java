
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 学校人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuexiaorenyuan")
public class XuexiaorenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(XuexiaorenyuanController.class);

    private static final String TABLE_NAME = "xuexiaorenyuan";

    @Autowired
    private XuexiaorenyuanService xuexiaorenyuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JianliService jianliService;//简历
    @Autowired
    private QiyeService qiyeService;//企业
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhaopinService zhaopinService;//职位招聘
    @Autowired
    private ZhaopinChatService zhaopinChatService;//用户咨询
    @Autowired
    private ZhaopinCollectionService zhaopinCollectionService;//职位收藏
    @Autowired
    private ZhaopinLiuyanService zhaopinLiuyanService;//职位留言
    @Autowired
    private ZhaopinToudiService zhaopinToudiService;//简历投递
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("企业".equals(role))
            params.put("qiyeId",request.getSession().getAttribute("userId"));
        else if("学校人员".equals(role))
            params.put("xuexiaorenyuanId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = xuexiaorenyuanService.queryPage(params);

        //字典表数据转换
        List<XuexiaorenyuanView> list =(List<XuexiaorenyuanView>)page.getList();
        for(XuexiaorenyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuexiaorenyuanEntity xuexiaorenyuan = xuexiaorenyuanService.selectById(id);
        if(xuexiaorenyuan !=null){
            //entity转view
            XuexiaorenyuanView view = new XuexiaorenyuanView();
            BeanUtils.copyProperties( xuexiaorenyuan , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XuexiaorenyuanEntity xuexiaorenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuexiaorenyuan:{}",this.getClass().getName(),xuexiaorenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XuexiaorenyuanEntity> queryWrapper = new EntityWrapper<XuexiaorenyuanEntity>()
            .eq("username", xuexiaorenyuan.getUsername())
            .or()
            .eq("xuexiaorenyuan_phone", xuexiaorenyuan.getXuexiaorenyuanPhone())
            .or()
            .eq("xuexiaorenyuan_id_number", xuexiaorenyuan.getXuexiaorenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuexiaorenyuanEntity xuexiaorenyuanEntity = xuexiaorenyuanService.selectOne(queryWrapper);
        if(xuexiaorenyuanEntity==null){
            xuexiaorenyuan.setCreateTime(new Date());
            xuexiaorenyuan.setPassword("123456");
            xuexiaorenyuanService.insert(xuexiaorenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者学校人员手机号或者学校人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuexiaorenyuanEntity xuexiaorenyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuexiaorenyuan:{}",this.getClass().getName(),xuexiaorenyuan.toString());
        XuexiaorenyuanEntity oldXuexiaorenyuanEntity = xuexiaorenyuanService.selectById(xuexiaorenyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xuexiaorenyuan.getXuexiaorenyuanPhoto()) || "null".equals(xuexiaorenyuan.getXuexiaorenyuanPhoto())){
                xuexiaorenyuan.setXuexiaorenyuanPhoto(null);
        }

            xuexiaorenyuanService.updateById(xuexiaorenyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XuexiaorenyuanEntity> oldXuexiaorenyuanList =xuexiaorenyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xuexiaorenyuanService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<XuexiaorenyuanEntity> xuexiaorenyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XuexiaorenyuanEntity xuexiaorenyuanEntity = new XuexiaorenyuanEntity();
//                            xuexiaorenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            xuexiaorenyuanEntity.setPassword("123456");//密码
//                            xuexiaorenyuanEntity.setXuexiaorenyuanName(data.get(0));                    //学校人员姓名 要改的
//                            xuexiaorenyuanEntity.setXuexiaorenyuanPhoto("");//详情和图片
//                            xuexiaorenyuanEntity.setXuexiaorenyuanPhone(data.get(0));                    //学校人员手机号 要改的
//                            xuexiaorenyuanEntity.setXuexiaorenyuanIdNumber(data.get(0));                    //学校人员身份证号 要改的
//                            xuexiaorenyuanEntity.setXuexiaorenyuanEmail(data.get(0));                    //邮箱 要改的
//                            xuexiaorenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xuexiaorenyuanEntity.setCreateTime(date);//时间
                            xuexiaorenyuanList.add(xuexiaorenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //学校人员手机号
                                if(seachFields.containsKey("xuexiaorenyuanPhone")){
                                    List<String> xuexiaorenyuanPhone = seachFields.get("xuexiaorenyuanPhone");
                                    xuexiaorenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xuexiaorenyuanPhone = new ArrayList<>();
                                    xuexiaorenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("xuexiaorenyuanPhone",xuexiaorenyuanPhone);
                                }
                                //学校人员身份证号
                                if(seachFields.containsKey("xuexiaorenyuanIdNumber")){
                                    List<String> xuexiaorenyuanIdNumber = seachFields.get("xuexiaorenyuanIdNumber");
                                    xuexiaorenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xuexiaorenyuanIdNumber = new ArrayList<>();
                                    xuexiaorenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xuexiaorenyuanIdNumber",xuexiaorenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XuexiaorenyuanEntity> xuexiaorenyuanEntities_username = xuexiaorenyuanService.selectList(new EntityWrapper<XuexiaorenyuanEntity>().in("username", seachFields.get("username")));
                        if(xuexiaorenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuexiaorenyuanEntity s:xuexiaorenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //学校人员手机号
                        List<XuexiaorenyuanEntity> xuexiaorenyuanEntities_xuexiaorenyuanPhone = xuexiaorenyuanService.selectList(new EntityWrapper<XuexiaorenyuanEntity>().in("xuexiaorenyuan_phone", seachFields.get("xuexiaorenyuanPhone")));
                        if(xuexiaorenyuanEntities_xuexiaorenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuexiaorenyuanEntity s:xuexiaorenyuanEntities_xuexiaorenyuanPhone){
                                repeatFields.add(s.getXuexiaorenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [学校人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //学校人员身份证号
                        List<XuexiaorenyuanEntity> xuexiaorenyuanEntities_xuexiaorenyuanIdNumber = xuexiaorenyuanService.selectList(new EntityWrapper<XuexiaorenyuanEntity>().in("xuexiaorenyuan_id_number", seachFields.get("xuexiaorenyuanIdNumber")));
                        if(xuexiaorenyuanEntities_xuexiaorenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuexiaorenyuanEntity s:xuexiaorenyuanEntities_xuexiaorenyuanIdNumber){
                                repeatFields.add(s.getXuexiaorenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [学校人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xuexiaorenyuanService.insertBatch(xuexiaorenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XuexiaorenyuanEntity xuexiaorenyuan = xuexiaorenyuanService.selectOne(new EntityWrapper<XuexiaorenyuanEntity>().eq("username", username));
        if(xuexiaorenyuan==null || !xuexiaorenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(xuexiaorenyuan.getId(),username, "xuexiaorenyuan", "学校人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","学校人员");
        r.put("username",xuexiaorenyuan.getXuexiaorenyuanName());
        r.put("tableName","xuexiaorenyuan");
        r.put("userId",xuexiaorenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XuexiaorenyuanEntity xuexiaorenyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XuexiaorenyuanEntity> queryWrapper = new EntityWrapper<XuexiaorenyuanEntity>()
            .eq("username", xuexiaorenyuan.getUsername())
            .or()
            .eq("xuexiaorenyuan_phone", xuexiaorenyuan.getXuexiaorenyuanPhone())
            .or()
            .eq("xuexiaorenyuan_id_number", xuexiaorenyuan.getXuexiaorenyuanIdNumber())
            ;
        XuexiaorenyuanEntity xuexiaorenyuanEntity = xuexiaorenyuanService.selectOne(queryWrapper);
        if(xuexiaorenyuanEntity != null)
            return R.error("账户或者学校人员手机号或者学校人员身份证号已经被使用");
        xuexiaorenyuan.setCreateTime(new Date());
        xuexiaorenyuanService.insert(xuexiaorenyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        XuexiaorenyuanEntity xuexiaorenyuan = xuexiaorenyuanService.selectById(id);
        xuexiaorenyuan.setPassword("123456");
        xuexiaorenyuanService.updateById(xuexiaorenyuan);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        XuexiaorenyuanEntity xuexiaorenyuan = xuexiaorenyuanService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(xuexiaorenyuan.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(xuexiaorenyuan.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        xuexiaorenyuan.setPassword(newPassword);
		xuexiaorenyuanService.updateById(xuexiaorenyuan);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XuexiaorenyuanEntity xuexiaorenyuan = xuexiaorenyuanService.selectOne(new EntityWrapper<XuexiaorenyuanEntity>().eq("username", username));
        if(xuexiaorenyuan!=null){
            xuexiaorenyuan.setPassword("123456");
            xuexiaorenyuanService.updateById(xuexiaorenyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrXuexiaorenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XuexiaorenyuanEntity xuexiaorenyuan = xuexiaorenyuanService.selectById(id);
        if(xuexiaorenyuan !=null){
            //entity转view
            XuexiaorenyuanView view = new XuexiaorenyuanView();
            BeanUtils.copyProperties( xuexiaorenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xuexiaorenyuanService.queryPage(params);

        //字典表数据转换
        List<XuexiaorenyuanView> list =(List<XuexiaorenyuanView>)page.getList();
        for(XuexiaorenyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuexiaorenyuanEntity xuexiaorenyuan = xuexiaorenyuanService.selectById(id);
            if(xuexiaorenyuan !=null){


                //entity转view
                XuexiaorenyuanView view = new XuexiaorenyuanView();
                BeanUtils.copyProperties( xuexiaorenyuan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XuexiaorenyuanEntity xuexiaorenyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuexiaorenyuan:{}",this.getClass().getName(),xuexiaorenyuan.toString());
        Wrapper<XuexiaorenyuanEntity> queryWrapper = new EntityWrapper<XuexiaorenyuanEntity>()
            .eq("username", xuexiaorenyuan.getUsername())
            .or()
            .eq("xuexiaorenyuan_phone", xuexiaorenyuan.getXuexiaorenyuanPhone())
            .or()
            .eq("xuexiaorenyuan_id_number", xuexiaorenyuan.getXuexiaorenyuanIdNumber())
//            .notIn("xuexiaorenyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuexiaorenyuanEntity xuexiaorenyuanEntity = xuexiaorenyuanService.selectOne(queryWrapper);
        if(xuexiaorenyuanEntity==null){
            xuexiaorenyuan.setCreateTime(new Date());
            xuexiaorenyuan.setPassword("123456");
        xuexiaorenyuanService.insert(xuexiaorenyuan);

            return R.ok();
        }else {
            return R.error(511,"账户或者学校人员手机号或者学校人员身份证号已经被使用");
        }
    }

}

