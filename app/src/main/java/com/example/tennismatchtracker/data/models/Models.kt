@Entity(tableName = "players")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val wtnRating: Double? = null,
    val ranking: Int? = null,
    @ColumnInfo(name = "handedness")
    val handedness: Handedness = Handedness.RIGHT,
    val notes: String? = null
)

@Entity(tableName = "matches")
data class Match(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: Long,
    @ColumnInfo(name = "competition_type")
    val competitionType: CompetitionType,
    @Embedded(prefix = "opponent_")
    val opponent: Player,
    @Embedded(prefix = "score_")
    val score: Score,
    val result: MatchResult,
    val surface: SurfaceType? = null,
    val environment: Environment? = null,
    val notes: String? = null
)

// Add TypeConverters for complex types
@TypeConverters(Converters::class)
data class Score(
    val sets: List<Set>,
    val matchStatus: MatchStatus = MatchStatus.COMPLETED
)

data class Set(
    val playerScore: Int,
    val opponentScore: Int,
    val tiebreakScore: String? = null
) 