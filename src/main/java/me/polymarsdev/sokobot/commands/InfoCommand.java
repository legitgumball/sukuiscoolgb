package me.polymarsdev.sokobot.commands;

import me.polymarsdev.sokobot.Bot;
import me.polymarsdev.sokobot.entity.Command;
import me.polymarsdev.sokobot.event.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;

public class InfoCommand extends Command {

    public InfoCommand() {
        super("info");
    }

    @Override
    public void execute(CommandEvent event) {
        Bot.debug("Received info command (or bot mention)");
        Guild guild = event.getGuild();
        EmbedBuilder info = new EmbedBuilder();
        final String prefix = Bot.getPrefix(guild);
        info.setTitle("Sokobot");
        info.setThumbnail(guild.getSelfMember().getUser().getAvatarUrl());
        info.setDescription("Sokobot is a bot that lets you play Sokoban, the classic box-pushing puzzle game.");
        info.setColor(0xdd2e53);
        info.addField("How to Play", "You are a **Sokoban** :flushed:.\nYour job is to push **boxes** :brown_square: "
                + "on top of their **destinations** :negative_squared_cross_mark:.", false);
        info.addField("Features", ":white_small_square:**Infinite levels**\nThe maps in Sokobot are randomly "
                + "generated, increasing in difficulty as you progress.\n:white_small_square:**Varied " + "controls"
                + "**\nSokobot has multiple control options to improve the player's experience, including "
                + "reactions and wasd commands!\n:white_small_square:**Simultaneous games**\nThanks to the power of "
                + "Java HashMaps:tm:, multiple users can use the bot at the same time without interfering with one "
                + "another.\n:white_small_square:**Custom prefixes**\nTo prevent Sokobot from conflicting with other "
                + "bots, admins can choose any single-character prefix to preface Sokobot's commands.", false);
        info.addField(
                "Commands",
                ("``" + prefix + "play`` can be used to start a game if you are not " + "currently in " + "one.\n``"
                        + prefix + "stop`` can be used to stop your active game at any " + "time.\n``" + prefix
                        + "info`` provides some useful details about the bot and " + "rules of " + "the game.\n``" + Bot
                        .getPrefix(guild) + "prefix [character]`` can be used to " + "change the prefix the "
                        + "bot responds to."), false);
        info.addField(
                "thank you for using my bot",
                "gumball game bot is currently in " + Bot.getShardManager().getGuilds()
                                                                                       .size() + " servers.", false);
        /*
        // Official Support Server
        info.addField("Support / Feedback",
        "Official Support Server: https://invite.affluentproductions.org/apserver", false);
         */
        info.addField("add to your server", "https://discord.com/api/oauth2/authorize?client_id=8...", false);
        info.setFooter("created by gumball#0001",);
        event.reply(info.build());
    }
}
