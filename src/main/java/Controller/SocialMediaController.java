package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.AccountDAO;

import static org.mockito.ArgumentMatchers.nullable;

import com.fasterxml.jackson.core.JsonProcessingException;

import Model.Account;
import Service.AccountService;
import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {

    //MessageService messageService;
    AccountService accountService;

    public SocialMediaController(){
        //this.messageService = new BookService();
        this.accountService = new AccountService();
    }

    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.post("/register", this::postRegisterHandler);
        app.post("/login", this::postLoginHandler);
        app.post("/messages", this::postMessagesHandler);
        app.get("/messages", this::getMessagesHandler);
        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void postRegisterHandler(Context ctx)throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Account account = om.readValue(ctx.body(), Account.class);
        Account addedAccount = accountService.addAccount(account);
        // if(om.writeValueAsString(account) == null)
        // {
        //     ctx.status(400);
        // }

        // if(account.password.length() < 4)
        // {
        //     ctx.status(400);
        // }

        // if(account.username == account.getUsername())
        // {
        //     ctx.status(400);
        // }

        if(account.username != null)
        {
            ctx.status(400);
        }

        if(account.password. < 4)
        {
            ctx.status(400);
        }

        if (account.username.isEmpty() == false) {
            ctx.json(om.writeValueAsString(addedAccount));
            ctx.status(200);
        }
    }

    private void postLoginHandler(Context ctx) {
        ctx.json("sample text");
    }

    private void postMessagesHandler(Context ctx) {
        ctx.json("sample text");
    }

    private void getMessagesHandler(Context ctx) {
        ctx.json("sample text");
    }

}