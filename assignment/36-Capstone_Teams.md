#   CSCE 361 Capstone Teams

Below are the teams for the capstone project. As noted in the scoping document,
the teams were formed thusly:

-   You may request to be teamed with other students. We will attempt to honor
    these requests but do not guarantee that we will do so.
-   Beyond such requests, teams will be formed semi-randomly. Team assignment
    will be semi-random in that we will take into account student performance
    in prior assignments, both the quality of contribution and the willingness
    to contribute.
    -   We will strive to balance the teams' collective mastery of the course
        material, so that if a student is weak in some particular area, other
        team members will be able to help them out.
    -   Except as noted below, we will assign at most one student per team
        whose prior performance indicates they are a habitual poor team member,
        either by not contributing an equitable share, or by failing to
        coordinate with other team members.
    -   If there are enough poor team members, we will create a team or teams
        consisting only of poor team members.

We were able to honor most teaming requests. *The only teaming requests we did
not honor involved one person requesting to be teamed with another person, but
we had no indication that the other person assented to the teaming request.*
Some of the requested teams gained one or two other students.

We were generally able to balance the teams' collective mastery of the course
material; the high- and low-outliers (as measured by average mastery of the
course material) are the result of team requests that I could not balance
enough to bring closer to the main cluster of teams' collective mastery.

My original intent was to make sure no team had more than one team member with
less than an 80% "teamwork" average score; however, we were able to further
ensure that no team has more than one team member with less than a 90%
"teamwork" average score. We did not create a team consisting solely of poor
team members.

Between now and Monday, decide what your team's project preferences are and
send me your rank-ordered list. Projects will be matched to teams using the
FIFO mechanism described with the project descriptions. In the interest of
giving all teams the opportunity to discuss their preferences and also giving
us time to make project assignments, I will accept teams' project preferences
only between 4:00pm on Friday, November 15, and 9:30am on Monday, November 18.

-   This is not Oklahoma. You cannot stake a claim "sooner" than the designated
    time.
-   Teams that don't send their project preferences during this timeframe will
    be assumed to not have preferences.

While you and your team may discuss the high-level design and process-related
issues (such as your branching strategy), do **NOT** start development until
the "Kickoff Meeting" during class on Wednesday, November 20.

##  Clarification on Chess Requirements

In light of questions on Piazza, allow me to clarify what will and will not be
required for the Chess project:

-   Basic moves are required
-   A partial implementation of castling is required
    -   If the king has not previously moved, the king is not currently in
        check, the king's target square is empty, and the move would not place
        the king in check, then castling must be possible.
        -   You must gracefully handle the situation of the rook's target
            square being occupied; since this would normally be illegal under
            chess rules you can decide what to do with the piece the rook
            replaces.
    -   Stretch goal: castling is not possible if
        -   The rook previously moved
        -   Any of the squares between the king and the rook are occupied
        -   Any of the squares between the king and the king's target square
            are "under attack" (the king cannot pass through check during
            castling)
-   Capturing a pawn *en passant* is a stretch goal
-   Pawn promotion is required. Hint: there is a clean solution involving the
    Strategy Pattern.
-   The system must detect when a king is in check. Moreover, a player cannot
    end their turn with their king in check.
    -   The system must also disallow a player's move would place that player's
        own king in check (naturally, a move that places the *other* player's
        king in check is allowed).
    -   The system must require a player in check to make a move to get out of
        check (if possible).
-   The end of the game:
    -   The system must detect checkmate (a player's king is in check and that
        player has no legal moves).
    -   The system must detect stalemate (a player's king is not in check and
        that player has no legal moves).
    -   The system must detect the fifty-move rule.
    -   The system must allow a player to resign.
    -   The system must allow a player to offer a draw and the other player to
        accept the draw.
    -   Detecting threefold repetition is a stretch goal.
    -   Detecting a configuration with no possibility of checkmate is a stretch
        goal.

##  Teams

-   Team 1
    -   Hundter Biede, gitlab @hbiede, email <hbiede@huskers.unl.edu> <hbiede@gmail.com>
    -   Hunter Dorhout, gitlab @hdorhout, email <hdorhout@huskers.unl.edu> <hdorhout07@gmail.com>
    -   John Earnest, gitlab @johnearnest44, email <jearnest121@huskers.unl.edu> <johnearnest44@gmail.com>
    -   Dan Thibodeau, gitlab @dan.thibodeau, email <dan.thibodeau@huskers.unl.edu>

-   Team 2
    -   Christine Discenza, gitlab @christine.discenza, email <christine.discenza@huskers.unl.edu>
    -   Shawn Knowlton, gitlab @shawn.knowlton, email <shawn.knowlton@huskers.unl.edu>
    -   Austin Schilz, gitlab @austin.schilz, email <austin.schilz@huskers.unl.edu>

-   Team 3
    -   Isaac Askey, gitlab @iaskey, email <iaskey@huskers.unl.edu>
    -   Jeremiah Cantu, gitlab @jcantu, email <jcantu@huskers.unl.edu>
    -   Nirmitee Gite, gitlab @ngite2, email <nirmitee.gite@huskers.unl.edu>
    -   Daniel Shchur, gitlab @docquantum, email <daniel.shchur@huskers.unl.edu>

-   Team 4
    -   Levi Hagen, gitlab @levi.hagen, email <levi.hagen@huskers.unl.edu>
    -   Zoe Hudson, gitlab @zoe.hudson, email <zoe.hudson@huskers.unl.edu>
    -   Cole McReynolds, gitlab @colemcreynolds, email <cmcreynolds@huskers.unl.edu>
    -   Peter Nguyen, gitlab @petervnguyen99, email <petervnguyen99@huskers.unl.edu> <petervnguyen99@gmail.com>

-   Team 5
    -   Conner Elliott, gitlab @conner.elliott, email <conner.elliott@huskers.unl.edu> <coellio5@gmail.com>
    -   Mario Gomez, gitlab @mario.gomez, email <mario.gomez@huskers.unl.edu> <mgomez6@unl.edu>
    -   Paul O'Dell, gitlab @paul.o-dell, email <prodell11@gmail.com> <paul.o-dell@huskers.unl.edu>
    -   Josh Seamans, gitlab @josh, email <josh.seamans@huskers.unl.edu> <josh@seamans.me>

-   Team 6
    -   David Gao, gitlab @582435572, email <david.gao313@huskers.unl.edu> <582435572@qq.com>
    -   Qiwei Ge, gitlab @qge, email <qge@huskers.unl.edu> <qiwei@laurens-air-2.unl.edu>
    -   Pengxiang Zhang, gitlab @pengxiangzhang, email <pengxiangzhang@huskers.unl.edu>
    -   Xinyi Zhu, gitlab @zhuxinyishcn, email <zhuxinyishcn@huskers.unl.edu>

-   Team 7
    -   Jacob Atkins, gitlab @atkins.jacob, email <atkins.jacob@huskers.unl.edu>
    -   Elliott Heineman, gitlab @elliott.heineman, email <elliott.heineman@huskers.unl.edu>
    -   Anirudh Patchipulusu, gitlab @apatchipulusu, email <apatchipulusu@huskers.unl.edu>
    -   Devan Steiner, gitlab @devan.steiner, email <devan.steiner@huskers.unl.edu>

-   Team 8
    -   Matthew Kuhry, gitlab @mkuhry, email <mkuhry@huskers.unl.edu>
    -   Ayush Mishra, gitlab @ayush.mishra, email <ayush.mishra@huskers.unl.edu>
    -   Soham Sandeepbhai Patel, gitlab @ssp, email <sohampatel1306@gmail.com> <ssp@huskers.unl.edu>
    -   Ryan Thomas, gitlab @rthomas, email <rycospam@gmail.com> <rsthomas@huskers.unl.edu>

-   Team 9
    -   Jaelle Kondohoma, gitlab @jaellek, email <jaelle.kondohoma@huskers.unl.edu> <jaellek@yahoo.com>
    -   Sarah Kornbluh, gitlab @skornbluh, email <skornbluh@huskers.unl.edu>
    -   Kassidy Maher, gitlab @kmaher, email <kmaher@huskers.unl.edu>
    -   Amanda Rowley, gitlab @arowley, email <arowley@huskers.unl.edu> <arowley2@unl.edu>

-   Team 10
    -   Cody Berglund, gitlab @cody.berglund, email <cody.berglund@huskers.unl.edu>
    -   Sean Termini, gitlab @sean.termini, email <sean.termini@huskers.unl.edu> <seantermini@sbcglobal.net>
    -   Siyi Li, gitlab @lisiyi_9887, email <lisiyi-9887@huskers.unl.edu> <lisiyi_9887@126.com>
    -   Bernard Lee, gitlab @bernardlee-99, email <bernard.lee@huskers.unl.edu> <bernardlee-99@outlook.com>

-   Team 11
    -   Jacob Fox, gitlab @jfox40, email <jfox40@huskers.unl.edu>
    -   Achintya Handa, gitlab @achintyahanda, email <achintyahanda@huskers.unl.edu>
    -   Sterling Holmes, gitlab @sterling.holmes, email <sterling.holmes@huskers.unl.edu>
    -   Shreeya Vaitla, gitlab @svaitla, email <svaitla@huskers.unl.edu>

-   Team 12
    -   Abdelrahman Ahmed Mohamed Saad, gitlab @asaad3, email <asaad3@huskers.unl.edu> <abdelrahman.a171@gmail.com>
    -   Isaac Gillette, gitlab @isaac.gillette21, email <isaac.gillette21@huskers.unl.edu>
    -   Trang Le, gitlab @tle12, email <trangle@huskers.unl.edu>
    -   Bojun Zhong, gitlab @bojun, email <bojun@huskers.unl.edu>
