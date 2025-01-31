class TennisRepository(
    private val playerDao: PlayerDao,
    private val matchDao: MatchDao
) {
    val allPlayers: Flow<List<Player>> = playerDao.getAllPlayers()
    val allMatches: Flow<List<Match>> = matchDao.getAllMatches()

    suspend fun insertPlayer(player: Player) {
        playerDao.insertPlayer(player)
    }

    suspend fun insertMatch(match: Match) {
        matchDao.insertMatch(match)
    }

    fun getPlayerById(id: Long): Flow<Player> = playerDao.getPlayerById(id)
    
    fun getMatchById(id: Long): Flow<Match> = matchDao.getMatchById(id)
} 