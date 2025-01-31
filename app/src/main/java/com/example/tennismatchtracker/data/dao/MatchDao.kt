@Dao
interface MatchDao {
    @Query("SELECT * FROM matches ORDER BY date DESC")
    fun getAllMatches(): Flow<List<Match>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(match: Match)

    @Delete
    suspend fun deleteMatch(match: Match)

    @Query("SELECT * FROM matches WHERE id = :matchId")
    fun getMatchById(matchId: Long): Flow<Match>
} 